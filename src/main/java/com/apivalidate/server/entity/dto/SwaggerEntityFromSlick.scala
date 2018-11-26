package com.apivalidate.server.entity.dto

import com.apivalidate.server.entity.Tables._

case class AttributeRowEntity(projectName: String, beanName: String, attributeName: String, attributeType: Option[String] = None, format: Option[String] = None, regular: Option[String] = None, enable: Boolean = false, $ref: Option[String] = None, createAt: java.sql.Timestamp, updateAt: java.sql.Timestamp)

case class BeanRowEntity(attrs: List[AttributeRowEntity], beanName: String, projectName: String, beanType: String, createAt: java.sql.Timestamp, updateAt: java.sql.Timestamp)

case class ParameterRowEntity(projectName: String, bindType: String, requestMethod: String, requestMapping: String, paramName: String, paramType: String, format: Option[String] = None, regular: Option[String] = None, enable: Boolean = false, createAt: java.sql.Timestamp, updateAt: java.sql.Timestamp)

case class PathRowEntity(params: Option[Seq[ParameterRow]], body: Option[BeanRow], projectName: String, requestMapping: String, requestMethod: String, definition: Option[String] = None, createAt: java.sql.Timestamp, updateAt: java.sql.Timestamp)

case class SwaggerApiRowEntity(paths: List[PathRowEntity], projectName: String, title: String, version: String, description: Option[String] = None, createAt: java.sql.Timestamp, updateAt: java.sql.Timestamp)


case class PathWithParams(path: PathRow, params: List[ParameterRow])

case class BeanWithAttrs(bean: BeanRow, attrs: List[AttributeRow])

case class ALL(swaggerApi: SwaggerApiRow, paths: List[PathWithParams], beans: List[BeanWithAttrs], var bodyRegulars: Map[String, Any] = Map.empty)