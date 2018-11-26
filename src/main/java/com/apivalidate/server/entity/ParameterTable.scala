package com.apivalidate.server.entity

// AUTO-GENERATED Slick data model for table Parameter
trait ParameterTable {

  self:Tables  =>

  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}
  case class ParameterRow(projectName: String, bindType: String, requestMethod: String, requestMapping: String, paramName: String, paramType: String, format: Option[String] = None, regular: Option[String] = None, enable: Boolean = false, version: String, createAt: java.sql.Timestamp, updateAt: java.sql.Timestamp)
  implicit def GetResultParameterRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Boolean], e3: GR[java.sql.Timestamp]): GR[ParameterRow] = GR{
    prs => import prs._
    ParameterRow.tupled((<<[String], <<[String], <<[String], <<[String], <<[String], <<[String], <<?[String], <<?[String], <<[Boolean], <<[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  class Parameter(_tableTag: Tag) extends profile.api.Table[ParameterRow](_tableTag, Some("api_validate"), "parameter") {
    def * = (projectName, bindType, requestMethod, requestMapping, paramName, paramType, format, regular, enable, version, createAt, updateAt) <> (ParameterRow.tupled, ParameterRow.unapply)
    def ? = ((Rep.Some(projectName), Rep.Some(bindType), Rep.Some(requestMethod), Rep.Some(requestMapping), Rep.Some(paramName), Rep.Some(paramType), format, regular, Rep.Some(enable), Rep.Some(version), Rep.Some(createAt), Rep.Some(updateAt))).shaped.<>({r=>import r._; _1.map(_=> ParameterRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7, _8, _9.get, _10.get, _11.get, _12.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    val projectName: Rep[String] = column[String]("project_name", O.Length(255,varying=true))
    val bindType: Rep[String] = column[String]("bind_type", O.Length(255,varying=true))
    val requestMethod: Rep[String] = column[String]("request_method", O.Length(255,varying=true))
    val requestMapping: Rep[String] = column[String]("request_mapping", O.Length(255,varying=true))
    val paramName: Rep[String] = column[String]("param_name", O.Length(255,varying=true))
    val paramType: Rep[String] = column[String]("param_type", O.Length(255,varying=true))
    val format: Rep[Option[String]] = column[Option[String]]("format", O.Length(255,varying=true), O.Default(None))
    val regular: Rep[Option[String]] = column[Option[String]]("regular", O.Length(255,varying=true), O.Default(None))
    val enable: Rep[Boolean] = column[Boolean]("enable", O.Default(false))
    val version: Rep[String] = column[String]("version", O.Length(255,varying=true))
    val createAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("create_at")
    val updateAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("update_at")
  }
  lazy val Parameter = new TableQuery(tag => new Parameter(tag))
  implicit class ParameterHelper(q: Query[Tables.Parameter, Tables.Parameter#TableElementType, scala.Seq]) {
    
      def dynamicQuery(condition: AnyRef) = {
        Parameter.filter { f =>
          val conditionList = SlickUtils.ccToMapNotNull(condition)
            .foldLeft(List[Rep[Boolean]]()) { (A, B) =>
              val next = B._1 match {
                case "projectName"=>f.projectName === B._2.asInstanceOf[String]
                case "bindType"=>f.bindType === B._2.asInstanceOf[String]
                case "requestMethod"=>f.requestMethod === B._2.asInstanceOf[String]
                case "requestMapping"=>f.requestMapping === B._2.asInstanceOf[String]
                case "paramName"=>f.paramName === B._2.asInstanceOf[String]
                case "paramType"=>f.paramType === B._2.asInstanceOf[String]
                case "format"=>f.format === B._2.asInstanceOf[String]
                case "regular"=>f.regular === B._2.asInstanceOf[String]
                case "enable"=>f.enable === B._2.asInstanceOf[Boolean]
                case "version"=>f.version === B._2.asInstanceOf[String]
                case "createAt"=>f.createAt === B._2.asInstanceOf[java.sql.Timestamp]
                case "updateAt"=>f.updateAt === B._2.asInstanceOf[java.sql.Timestamp]
                
              }
              A :+ next.asInstanceOf[Rep[Boolean]]
            }
          conditionList.reduceLeft(_ && _)
        }
      }
           
    def dynamicSort(column: String = "", sort: String = "asc") = {
  column match {
          case "" => q

          case "projectName" =>
            sort match {
              case "asc" => q.sortBy(_.projectName.asc)
              case "desc" => q.sortBy(_.projectName.desc)
            }
             
          case "bindType" =>
            sort match {
              case "asc" => q.sortBy(_.bindType.asc)
              case "desc" => q.sortBy(_.bindType.desc)
            }
             
          case "requestMethod" =>
            sort match {
              case "asc" => q.sortBy(_.requestMethod.asc)
              case "desc" => q.sortBy(_.requestMethod.desc)
            }
             
          case "requestMapping" =>
            sort match {
              case "asc" => q.sortBy(_.requestMapping.asc)
              case "desc" => q.sortBy(_.requestMapping.desc)
            }
             
          case "paramName" =>
            sort match {
              case "asc" => q.sortBy(_.paramName.asc)
              case "desc" => q.sortBy(_.paramName.desc)
            }
             
          case "paramType" =>
            sort match {
              case "asc" => q.sortBy(_.paramType.asc)
              case "desc" => q.sortBy(_.paramType.desc)
            }
             
          case "format" =>
            sort match {
              case "asc" => q.sortBy(_.format.asc)
              case "desc" => q.sortBy(_.format.desc)
            }
             
          case "regular" =>
            sort match {
              case "asc" => q.sortBy(_.regular.asc)
              case "desc" => q.sortBy(_.regular.desc)
            }
             
          case "enable" =>
            sort match {
              case "asc" => q.sortBy(_.enable.asc)
              case "desc" => q.sortBy(_.enable.desc)
            }
             
          case "version" =>
            sort match {
              case "asc" => q.sortBy(_.version.asc)
              case "desc" => q.sortBy(_.version.desc)
            }
             
          case "createAt" =>
            sort match {
              case "asc" => q.sortBy(_.createAt.asc)
              case "desc" => q.sortBy(_.createAt.desc)
            }
             
          case "updateAt" =>
            sort match {
              case "asc" => q.sortBy(_.updateAt.asc)
              case "desc" => q.sortBy(_.updateAt.desc)
            }
             
  }
  }
           
  }
}
