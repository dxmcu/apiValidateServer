package com.apivalidate.server.controller

import com.apivalidate.server.controller.{User, UserGroup}
import org.springframework.web.bind.annotation._

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.util.{Failure, Success}


@RestController
@RequestMapping(value = Array("json"))
class JsonTestController {
  implicit val ec = ExecutionContext.global

  @GetMapping(value = Array("/get/user"))
  def getUser() = {
    val sUser = User(1, "xiaoming", Some(18))
    sUser
  }

  @GetMapping(value = Array("/get/user/future"))
  def getUserFuture() = {
    val sUser = User(1, "xiaoming", Some(18))
    Thread.sleep(1000)
    Await.result(Future(sUser), Duration.Inf)
  }

  @PostMapping(value = Array("/post/user"))
  def createUser(@RequestBody user: User) = {
    user
  }

  @PostMapping(value = Array("/post/userjson"))
  def createUserjson(@RequestBody user: Map[String, Any]) = {
    user
  }

  @GetMapping(value = Array("/list/user-group"))
  def listUserGroup() = {
    List(UserGroup(1, "g1", List(User(1, "xiaoming", Some(18)))))
  }

  @PostMapping(value = Array("/post/user-group"))
  def createUserGroup(@RequestBody ug: UserGroup) = {
    ug
  }

  @GetMapping(value = Array("/basetype/int"))
  def baseTypeInt() = {
    1
  }

  @GetMapping(value = Array("/basetype/long"))
  def baseTypeLong() = {
    1L
  }

  @GetMapping(value = Array("/basetype/boole"))
  def baseTypeBoole() = {
    false
  }

  @GetMapping(value = Array("/basetype/string"))
  def baseTypeString() = {
    1
  }
}
