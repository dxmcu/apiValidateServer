package com.apivalidate.server.controller


import org.springframework.web.bind.annotation._
import com.apivalidate.server.entity.dto.SwaggerType.BeanName
import com.apivalidate.server.util.{JsonUtil, SwaggerUtil, Utils}
import com.apivalidate.server.entity.dto._
import com.apivalidate.server.entity.Tables._
import slick.jdbc.MySQLProfile.api._
import com.apivalidate.server.entity.Tables.Parameter
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.Async

import scala.concurrent.{Await, ExecutionContext}
import scala.concurrent.duration.Duration
import scala.language.implicitConversions
import scala.concurrent.java8.FuturesConvertersImpl._
import scala.concurrent.{ExecutionContext, ExecutionContextExecutor, ExecutionContextExecutorService, Future, Promise}
import java.util.concurrent.{CompletionStage, Executor, ExecutorService}
import java.util.function.Consumer
import java.util.concurrent.CompletionStage

import junit.framework.Test

import scala.concurrent.Future
import scala.compat.java8.FutureConverters


@RestController
@RequestMapping(value = Array("apivalidate/server"))
class ApiValidateController {
  implicit val ec = ExecutionContext.global

  @PostMapping(value = Array("/swagger/json"))
  def saveSwaggerJson(@RequestBody api: SwaggerAPI): Unit = {
    println(api)

    val origin: String = JsonUtil.objectMapper.writeValueAsString(api)
    println(origin)
    val pathAndParam = api.paths.map { path =>
      val requestMapping = path._1
      val requestMethod = path._2.keys.head
      val methodDetail = path._2.values.head
      val defintion: Option[String] = methodDetail.parameters match {
        case Some(params) => params
          .filter(_.in.equals("body")).map(_.schema).headOption match {
          case Some(schema) =>
            schema.`type` match {
              case null =>
                SwaggerUtil.refToBeanName(Some(schema.$ref))
              case "array" =>
                SwaggerUtil.refToBeanName(Some(schema.items.ref))
              case others =>
                None
            }
          case None =>
            None
        }
        case None => None
      }

      val pathRow = PathRow(api.projectName, requestMapping, requestMethod, defintion, Utils.currentTimestamp, Utils.currentTimestamp)

      val parameters = methodDetail.parameters match {
        case Some(params) =>
          params.filter(fp => fp.in.equals("path") || fp.in.equals("query")).map { m =>
            ParameterRow(api.projectName, m.in, requestMethod, requestMapping, m.name, m.`type`, m.format, None, false, Utils.currentTimestamp, Utils.currentTimestamp)
          }
        case None => null
      }
      (pathRow, parameters)
    }
    val beanDetails = api.definitions.map {
      a: (BeanName, BeanDetail) => a._2.copy(beanName = a._1)
    }.toList


    val swaggerApiRow = SwaggerApiRow(api.projectName, api.info.title, api.info.version,
      Some(api.info.description), Utils.currentTimestamp, Utils.currentTimestamp)
    val pathRows = pathAndParam.keys
    val paramRows = pathAndParam.values.filter(null != _).flatten
    val beanRows = api.definitions.map {
      case (name: BeanName, detali: BeanDetail) =>
        BeanRow(name, api.projectName, detali.`type`, Utils.currentTimestamp, Utils.currentTimestamp)
    }
    val attributeRows = api.definitions.flatMap {
      case (beanName: BeanName, beanDetali: BeanDetail) =>
        beanDetali.properties.map {
          case (attributeName: String, attributeDetail: AttributeDetail) =>
            AttributeRow(api.projectName, beanName, attributeName, attributeDetail.`type`, attributeDetail.format,
              attributeDetail.regular, false, SwaggerUtil.refToBeanName(attributeDetail.$ref), Utils.currentTimestamp, Utils.currentTimestamp)
        }
    }

    val query = for {
      sa <- SwaggerApi += swaggerApiRow
      path <- Path ++= pathRows
      param <- Parameter ++= paramRows
      bean <- Bean ++= beanRows
      attr <- Attribute ++= attributeRows
    } yield 0

    Await.result(db.run(query), Duration.Inf)

    println("saving---------------")

  }

  @Async
  @GetMapping(value = Array("/swagger/json/{projectName}"))
  def getSwaggerJson(@PathVariable("projectName") projectName: String) = {

    var swaggerRow: Option[SwaggerApiRow] = None
    var pathRows: List[PathRow] = List.empty
    var pathWithParams: List[PathWithParams] = List.empty
    var beanWithAttrs: List[BeanWithAttrs] = List.empty

    val swaggerQuery = db.run(SwaggerApi.filter(_.projectName === projectName).result.headOption)
      .flatMap { swagger =>
        swaggerRow = swagger
        val query = Path.filter(_.projectName === projectName)
          .join(Parameter).on(
          (path, param) => path.projectName === param.projectName && path.requestMapping === param.requestMapping && path.requestMethod === param.requestMethod
        )
        db.run(query.result)
      }.flatMap { pathAndParam =>
      pathWithParams = pathAndParam.groupBy(_._1).map { case (path, pp) =>
        PathWithParams(path, pp.map(_._2).toList)
      }.toList

      val query = Bean.filter(_.projectName === projectName)
        .join(Attribute).on((bean, attr) => bean.projectName === attr.projectName && bean.beanName === attr.beanName)
      db.run(query.result)
    }.flatMap { fm =>
      beanWithAttrs = fm.groupBy(_._1).map { case (bean, ba) =>
        BeanWithAttrs(bean, ba.map(_._2).toList)
      }.toList
      Future {
        com.apivalidate.server.entity.dto.ALL(swaggerRow.orNull, pathWithParams, beanWithAttrs)
      }
    }

    //FutureConverters.toJava(swaggerQuery)
    FutureConverters.toJava(swaggerQuery.flatMap { all =>
      Future(allToJson(all))
    })

  }

  def allToJson(all: ALL) = {
    all.beans.map { bean =>
      Map(bean.bean.beanName -> beanToJson(bean, all.beans))
    }
  }

  def beanToJson(bean: BeanWithAttrs, beans: List[BeanWithAttrs]): Map[String, Option[String]] = {
    bean.attrs.map {
      case attr if attr.$ref.isEmpty =>
        Map(attr.attributeName -> attr.regular)
      case attr if attr.$ref.isDefined =>
        println(JsonUtil.objectMapper.writeValueAsString(attr))
        beanToJson(beans.filter(_.bean.beanName .equalsIgnoreCase( attr.$ref.getOrElse("肯定不一樣"))).head, beans)
    }.foldLeft(Map[String, Option[String]]()) { (A, B) => A ++ B }
  }


}
