package com.apivalidate.server.entity.dto

import com.apivalidate.server.entity.dto.SwaggerType.{BeanName, _}
import com.fasterxml.jackson.annotation.JsonProperty


case class SwaggerAPI(swagger: String,
                      projectName: String,
                      info: Info,
                      host: String,
                      basePath: String,
                      tags: List[Tag],
                      schemes: List[String],
                      paths: Path[RequestMapping, RequestDetail[RequestMethod, MethodDetail]], //url,Any
                      definitions: Definitions[BeanName, BeanDetail])

case class Info(description: String,
                version: String,
                title: String,
                termsOfService: String,
                contact: Map[String, String],
                license: Map[String, String])

case class Tag(name: String)

case class MethodDetail(
                         beanName: BeanName,
                         tags: List[String],
                         summary: String,
                         description: String,
                         operationId: String,
                         responses: Map[String, Any],
                         parameters: Option[List[Parameter]]
                       )

case class Parameter(in: String,
                     name: String,
                     required: Boolean,
                     schema: Schema,
                     `type`: String,
                     format: Option[String],
                     regular: String
                    )

case class Schema(`type`: String, $ref: String, items: Items)

case class Items(@JsonProperty("$ref")
                 ref: String) {

}

case class BeanDetail(beanName: BeanName, `type`: String, properties: Map[AttributeName, AttributeDetail])

case class AttributeDetail(`type`: Option[String], format: Option[String], regular: Option[String], $ref: Option[String])

