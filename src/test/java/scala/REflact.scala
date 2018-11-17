package scala

import com.apivalidate.server.util.Utils

import scala.Helpers.Criteria
import scala.reflect.runtime.universe._


object Helpers extends App {

  case class Criteria(
                       `authCompanyId`: Option[String] = None,
                       `internalInterchangeId`: Option[String] = None,
                       `documentIdentifier`: Option[String] = None,
                       `distribution`: Option[String] = None,
                       `direction`: Option[String] = None,
                       `sendType`: Option[String] = None,
                       `documentType`: Option[String] = None,
                       `dateFrom`: Option[String] = None,
                       `dateTo`: Option[String] = None,
                       name: String,
                       age: Int
                     )

  val c = Criteria(`authCompanyId` = Option("32232"),
    `distribution` = Option("MAIL"),
    `sendType` = Option("PROD"),
    `dateFrom` = Option("2017-11-15"), name = null, age = 18)

val resss=  Utils.ccToMapNotNull(c)
  resss

 val res2= Utils.ccToMap(Map("jaja"->123))
  res2
}
