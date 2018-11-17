package com.apivalidate.server.entity

// AUTO-GENERATED Slick data model for table Attribute
trait AttributeTable {

  self:Tables  =>

  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}
  case class AttributeRow(projectName: String, beanName: String, attributeName: String, attributeType: Option[String] = None, format: Option[String] = None, regular: Option[String] = None, enable: Boolean = false, $ref: Option[String] = None, createAt: java.sql.Timestamp, updateAt: java.sql.Timestamp)
  implicit def GetResultAttributeRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Boolean], e3: GR[java.sql.Timestamp]): GR[AttributeRow] = GR{
    prs => import prs._
    AttributeRow.tupled((<<[String], <<[String], <<[String], <<?[String], <<?[String], <<?[String], <<[Boolean], <<?[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  class Attribute(_tableTag: Tag) extends profile.api.Table[AttributeRow](_tableTag, Some("api_validate"), "attribute") {
    def * = (projectName, beanName, attributeName, attributeType, format, regular, enable, $ref, createAt, updateAt) <> (AttributeRow.tupled, AttributeRow.unapply)
    def ? = ((Rep.Some(projectName), Rep.Some(beanName), Rep.Some(attributeName), attributeType, format, regular, Rep.Some(enable), $ref, Rep.Some(createAt), Rep.Some(updateAt))).shaped.<>({r=>import r._; _1.map(_=> AttributeRow.tupled((_1.get, _2.get, _3.get, _4, _5, _6, _7.get, _8, _9.get, _10.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    val projectName: Rep[String] = column[String]("project_name", O.Length(255,varying=true))
    val beanName: Rep[String] = column[String]("bean_name", O.Length(255,varying=true))
    val attributeName: Rep[String] = column[String]("attribute_name", O.Length(255,varying=true))
    val attributeType: Rep[Option[String]] = column[Option[String]]("attribute_type", O.Length(255,varying=true), O.Default(None))
    val format: Rep[Option[String]] = column[Option[String]]("format", O.Length(255,varying=true), O.Default(None))
    val regular: Rep[Option[String]] = column[Option[String]]("regular", O.Length(255,varying=true), O.Default(None))
    val enable: Rep[Boolean] = column[Boolean]("enable", O.Default(false))
    val $ref: Rep[Option[String]] = column[Option[String]]("$ref", O.Length(255,varying=true), O.Default(None))
    val createAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("create_at")
    val updateAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("update_at")
  }
  lazy val Attribute = new TableQuery(tag => new Attribute(tag))
  implicit class AttributeHelper(q: Query[Tables.Attribute, Tables.Attribute#TableElementType, scala.Seq]) {
    
      def dynamicQuery(condition: AnyRef) = {
        Attribute.filter { f =>
          val conditionList = SlickUtils.ccToMapNotNull(condition)
            .foldLeft(List[Rep[Boolean]]()) { (A, B) =>
              val next = B._1 match {
                case "projectName"=>f.projectName === B._2.asInstanceOf[String]
                case "beanName"=>f.beanName === B._2.asInstanceOf[String]
                case "attributeName"=>f.attributeName === B._2.asInstanceOf[String]
                case "attributeType"=>f.attributeType === B._2.asInstanceOf[String]
                case "format"=>f.format === B._2.asInstanceOf[String]
                case "regular"=>f.regular === B._2.asInstanceOf[String]
                case "enable"=>f.enable === B._2.asInstanceOf[Boolean]
                case "$ref"=>f.$ref === B._2.asInstanceOf[String]
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
             
          case "beanName" =>
            sort match {
              case "asc" => q.sortBy(_.beanName.asc)
              case "desc" => q.sortBy(_.beanName.desc)
            }
             
          case "attributeName" =>
            sort match {
              case "asc" => q.sortBy(_.attributeName.asc)
              case "desc" => q.sortBy(_.attributeName.desc)
            }
             
          case "attributeType" =>
            sort match {
              case "asc" => q.sortBy(_.attributeType.asc)
              case "desc" => q.sortBy(_.attributeType.desc)
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
             
          case "$ref" =>
            sort match {
              case "asc" => q.sortBy(_.$ref.asc)
              case "desc" => q.sortBy(_.$ref.desc)
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
