package com.apivalidate.server.util

import com.alibaba.fastjson.JSON
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility
import com.fasterxml.jackson.annotation.PropertyAccessor
import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper}
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.annotation.JsonInclude.Include

object JsonUtil {
  def objectMapper = new ObjectMapper()
    .registerModule(DefaultScalaModule)
    .setVisibility(PropertyAccessor.FIELD, Visibility.ANY).
    configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)


}
