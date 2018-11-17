package com.apivalidate.server.controller

import org.springframework.web.bind.annotation._
import com.apivalidate.server.entity.Tables._
import slick.jdbc.MySQLProfile.api._

import scala.concurrent.Await
import scala.concurrent.duration.Duration

@RestController
@RequestMapping(value = Array("db"))
class DatabaseDDLController {


  @GetMapping(value = Array("/list/job"))
  def listJob() = {
  }


}