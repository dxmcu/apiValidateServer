package com.apivalidate.server.entity

// AUTO-GENERATED Slick data model for table Bean
trait BeanTable {

  self:Tables  =>

  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}
  case class BeanRow(beanName: String, projectName: String, beanType: String, version: String, createAt: java.sql.Timestamp, updateAt: java.sql.Timestamp)
  implicit def GetResultBeanRow(implicit e0: GR[String], e1: GR[java.sql.Timestamp]): GR[BeanRow] = GR{
    prs => import prs._
    BeanRow.tupled((<<[String], <<[String], <<[String], <<[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  class Bean(_tableTag: Tag) extends profile.api.Table[BeanRow](_tableTag, Some("api_validate"), "bean") {
    def * = (beanName, projectName, beanType, version, createAt, updateAt) <> (BeanRow.tupled, BeanRow.unapply)
    def ? = ((Rep.Some(beanName), Rep.Some(projectName), Rep.Some(beanType), Rep.Some(version), Rep.Some(createAt), Rep.Some(updateAt))).shaped.<>({r=>import r._; _1.map(_=> BeanRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    val beanName: Rep[String] = column[String]("bean_name", O.Length(255,varying=true))
    val projectName: Rep[String] = column[String]("project_name", O.Length(255,varying=true))
    val beanType: Rep[String] = column[String]("bean_type", O.Length(255,varying=true))
    val version: Rep[String] = column[String]("version", O.Length(255,varying=true))
    val createAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("create_at")
    val updateAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("update_at")
  }
  lazy val Bean = new TableQuery(tag => new Bean(tag))
  implicit class BeanHelper(q: Query[Tables.Bean, Tables.Bean#TableElementType, scala.Seq]) {
    
      def dynamicQuery(condition: AnyRef) = {
        Bean.filter { f =>
          val conditionList = SlickUtils.ccToMapNotNull(condition)
            .foldLeft(List[Rep[Boolean]]()) { (A, B) =>
              val next = B._1 match {
                case "beanName"=>f.beanName === B._2.asInstanceOf[String]
                case "projectName"=>f.projectName === B._2.asInstanceOf[String]
                case "beanType"=>f.beanType === B._2.asInstanceOf[String]
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

          case "beanName" =>
            sort match {
              case "asc" => q.sortBy(_.beanName.asc)
              case "desc" => q.sortBy(_.beanName.desc)
            }
             
          case "projectName" =>
            sort match {
              case "asc" => q.sortBy(_.projectName.asc)
              case "desc" => q.sortBy(_.projectName.desc)
            }
             
          case "beanType" =>
            sort match {
              case "asc" => q.sortBy(_.beanType.asc)
              case "desc" => q.sortBy(_.beanType.desc)
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
