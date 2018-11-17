package com.apivalidate.server.util

object SwaggerUtil {
  def refToBeanName($ref: Option[String]) = {
    $ref match {
      case Some(v) => Some(v.split("/").last)
      case None => None
    }
  }


}
