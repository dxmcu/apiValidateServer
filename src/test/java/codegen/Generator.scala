package codegen

object Generator extends App {
  val profile = "slick.jdbc.MySQLProfile"
  val jdbcDriver = "com.mysql.jdbc.Driver"
  val url = "jdbc:mysql://172.20.227.236:3306/api_validate"
  val outputDir = "dbfile"
  val pkg = "com.apivalidate.server.entity"
  val user = "root"
  val password = "mysql"
  val ignoreInvalidDefaults = "true"
  val codeGeneratorClass = "codegen.SourceCodeGenerator"
  val outputToMultipleFiles = "true"
  SourceCodeGenerator.main(Array(profile, jdbcDriver, url, outputDir, pkg, user, password, ignoreInvalidDefaults, codeGeneratorClass, outputToMultipleFiles))

}
