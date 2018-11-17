package com.apivalidate.server.entity

object SlickUtils {
  def ccToMap(cc: AnyRef) =
    (Map[String, Any]() /: cc.getClass.getDeclaredFields) {
      (a, f) =>
        f.setAccessible(true)
        a + (f.getName -> f.get(cc))
    }

  def ccToMapNotNull(cc: AnyRef) = {
    for {
      (k, v) <- SlickUtils.ccToMap(cc).filter(f => null != f._2 && None != f._2)
    } yield k -> (v match {
      case Some(value) => value
      case value => value
    })
  }
}
