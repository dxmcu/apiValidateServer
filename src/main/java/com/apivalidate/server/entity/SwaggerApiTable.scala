package com.apivalidate.server.entity

// AUTO-GENERATED Slick data model for table SwaggerApi
trait SwaggerApiTable {

  self:Tables  =>

  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}
  case class SwaggerApiRow(projectName: String, title: String, version: String, description: Option[String] = None, createAt: java.sql.Timestamp, updateAt: java.sql.Timestamp)
  implicit def GetResultSwaggerApiRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[java.sql.Timestamp]): GR[SwaggerApiRow] = GR{
    prs => import prs._
    SwaggerApiRow.tupled((<<[String], <<[String], <<[String], <<?[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  class SwaggerApi(_tableTag: Tag) extends profile.api.Table[SwaggerApiRow](_tableTag, Some("api_validate"), "swagger_api") {
    def * = (projectName, title, version, description, createAt, updateAt) <> (SwaggerApiRow.tupled, SwaggerApiRow.unapply)
    def ? = ((Rep.Some(projectName), Rep.Some(title), Rep.Some(version), description, Rep.Some(createAt), Rep.Some(updateAt))).shaped.<>({r=>import r._; _1.map(_=> SwaggerApiRow.tupled((_1.get, _2.get, _3.get, _4, _5.get, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    val projectName: Rep[String] = column[String]("project_name", O.PrimaryKey, O.Length(1024,varying=true))
    val title: Rep[String] = column[String]("title", O.Length(255,varying=true))
    val version: Rep[String] = column[String]("version", O.Length(255,varying=true))
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(1024,varying=true), O.Default(None))
    val createAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("create_at")
    val updateAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("update_at")
  }
  lazy val SwaggerApi = new TableQuery(tag => new SwaggerApi(tag))
  implicit class SwaggerApiHelper(q: Query[Tables.SwaggerApi, Tables.SwaggerApi#TableElementType, scala.Seq]) {
    
      def dynamicQuery(condition: AnyRef) = {
        SwaggerApi.filter { f =>
          val conditionList = SlickUtils.ccToMapNotNull(condition)
            .foldLeft(List[Rep[Boolean]]()) { (A, B) =>
              val next = B._1 match {
                case "projectName"=>f.projectName === B._2.asInstanceOf[String]
                case "title"=>f.title === B._2.asInstanceOf[String]
                case "version"=>f.version === B._2.asInstanceOf[String]
                case "description"=>f.description === B._2.asInstanceOf[String]
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
             
          case "title" =>
            sort match {
              case "asc" => q.sortBy(_.title.asc)
              case "desc" => q.sortBy(_.title.desc)
            }
             
          case "version" =>
            sort match {
              case "asc" => q.sortBy(_.version.asc)
              case "desc" => q.sortBy(_.version.desc)
            }
             
          case "description" =>
            sort match {
              case "asc" => q.sortBy(_.description.asc)
              case "desc" => q.sortBy(_.description.desc)
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
