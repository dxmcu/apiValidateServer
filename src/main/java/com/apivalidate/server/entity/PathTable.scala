package com.apivalidate.server.entity

// AUTO-GENERATED Slick data model for table Path
trait PathTable {

  self:Tables  =>

  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}
  case class PathRow(projectName: String, requestMapping: String, requestMethod: String, definition: Option[String] = None, createAt: java.sql.Timestamp, updateAt: java.sql.Timestamp)
  implicit def GetResultPathRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[java.sql.Timestamp]): GR[PathRow] = GR{
    prs => import prs._
    PathRow.tupled((<<[String], <<[String], <<[String], <<?[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  class Path(_tableTag: Tag) extends profile.api.Table[PathRow](_tableTag, Some("api_validate"), "path") {
    def * = (projectName, requestMapping, requestMethod, definition, createAt, updateAt) <> (PathRow.tupled, PathRow.unapply)
    def ? = ((Rep.Some(projectName), Rep.Some(requestMapping), Rep.Some(requestMethod), definition, Rep.Some(createAt), Rep.Some(updateAt))).shaped.<>({r=>import r._; _1.map(_=> PathRow.tupled((_1.get, _2.get, _3.get, _4, _5.get, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    val projectName: Rep[String] = column[String]("project_name", O.Length(1024,varying=true))
    val requestMapping: Rep[String] = column[String]("request_mapping", O.Length(1024,varying=true))
    val requestMethod: Rep[String] = column[String]("request_method", O.Length(16,varying=true))
    val definition: Rep[Option[String]] = column[Option[String]]("definition", O.Length(255,varying=true), O.Default(None))
    val createAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("create_at")
    val updateAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("update_at")
  }
  lazy val Path = new TableQuery(tag => new Path(tag))
  implicit class PathHelper(q: Query[Tables.Path, Tables.Path#TableElementType, scala.Seq]) {
    
      def dynamicQuery(condition: AnyRef) = {
        Path.filter { f =>
          val conditionList = SlickUtils.ccToMapNotNull(condition)
            .foldLeft(List[Rep[Boolean]]()) { (A, B) =>
              val next = B._1 match {
                case "projectName"=>f.projectName === B._2.asInstanceOf[String]
                case "requestMapping"=>f.requestMapping === B._2.asInstanceOf[String]
                case "requestMethod"=>f.requestMethod === B._2.asInstanceOf[String]
                case "definition"=>f.definition === B._2.asInstanceOf[String]
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
             
          case "requestMapping" =>
            sort match {
              case "asc" => q.sortBy(_.requestMapping.asc)
              case "desc" => q.sortBy(_.requestMapping.desc)
            }
             
          case "requestMethod" =>
            sort match {
              case "asc" => q.sortBy(_.requestMethod.asc)
              case "desc" => q.sortBy(_.requestMethod.desc)
            }
             
          case "definition" =>
            sort match {
              case "asc" => q.sortBy(_.definition.asc)
              case "desc" => q.sortBy(_.definition.desc)
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
