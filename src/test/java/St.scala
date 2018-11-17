import com.apivalidate.server.util.Utils

object St extends App {
case class A(s:String,b :B)
  case class B(s1:String)

 val map= Utils.ccToMap(A("a",B("b")))
  println(map)
}
