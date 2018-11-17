package com.apivalidate.server.config

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility
import com.fasterxml.jackson.annotation.PropertyAccessor
import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper}
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebMvcCinfig extends WebMvcConfigurer {

  override
  def configureMessageConverters(converters: java.util.List[HttpMessageConverter[_]]): Unit = {
    converters.add(jackson2HttpMessageConverter())

  }

  @Bean
  def jackson2HttpMessageConverter(): MappingJackson2HttpMessageConverter =
    new MappingJackson2HttpMessageConverter(objectMapper())

  @Bean
  def objectMapper(): ObjectMapper =
    new ObjectMapper() {
      setVisibility(PropertyAccessor.FIELD, Visibility.ANY)
      registerModule(DefaultScalaModule)
    }.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
}
