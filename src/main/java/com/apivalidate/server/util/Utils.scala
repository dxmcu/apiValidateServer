package com.apivalidate.server.util

import java.lang.reflect.Type
import java.sql.Timestamp

object Utils {
  def ccToMap(cc: AnyRef) =
    (Map[String, Any]() /: cc.getClass.getDeclaredFields) {
      (a, f) =>
        f.setAccessible(true)
        a + (f.getName -> f.get(cc))
    }

  def ccToMapNotNull(cc: AnyRef) = {
    for {
      (k, v) <- Utils.ccToMap(cc).filter(f => null != f._2 && None != f._2)
    } yield k -> (v match {
      case Some(value) => value
      case value => value
    })
  }

  def currentTimestamp = {
    new Timestamp(System.currentTimeMillis())
  }
}
