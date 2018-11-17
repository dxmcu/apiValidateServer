package com.apivalidate.server.entity.dto


object SwaggerType {
  type Path[K, +V] = scala.collection.immutable.Map[K, V]
  type RequestDetail[K, +V] = scala.collection.immutable.Map[K, V]
  type Definitions[K, +V] = scala.collection.immutable.Map[K, V]

  type RequestMapping = String
  type RequestMethod = String
  type BeanName = String
  type AttributeName = String
}
