package com.apivalidate.server.entity.dto

case class ValidateEntity(swaggerAPIEntity: SwaggerAPIEntity,
                          paths: List[PathEntity],
                         )

case class SwaggerAPIEntity(
                             title: String,
                             version: String,
                             description: String,
                             projectName: String, //title+version
                             paths: List[PathEntity]
                           )

case class PathEntity(
                       projectName: String,
                       requestMapping: String,
                       requestMethod: String,
                       params: List[PathParameterEntity],
                       definition: DefinitionsEntity
                     )

case class DefinitionsEntity(projectName: String, beanName: String, properties: List[AttributeEntity])

case class AttributeEntity(projectName: String, beanName: String, attributeName: String, attributeType: String,
                           format: String, regular: String, enable: Boolean, $ref: DefinitionsEntity)


case class PathParameterEntity(
                                bindType: String,
                                projectName: String,
                                requestMapping: String,
                                requestMethod: String,
                                paramName: String, //param1... or body
                                paramType: String,
                                format: String,
                                regular: String,
                                enable: Boolean
                              )
