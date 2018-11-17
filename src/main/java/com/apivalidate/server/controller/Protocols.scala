package com.apivalidate.server.controller

case class User(id: Int, name: String, age: Option[Int])

case class UserGroup(id: Int, groupname: String, users: List[User])