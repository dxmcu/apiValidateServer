/*
package com.scalaboot.squirrel.slickdemo

import com.scalaboot.squirrel.entity._
import slick.jdbc.MySQLProfile.api._

import scala.concurrent.ExecutionContext.Implicits.global
import com.scalaboot.squirrel.entity.Tables._

import scala.concurrent.Future

object SvmDDL extends App {

  listJob
  //  selectJob


  Thread.sleep(100000)

  def listWithFilter = {
  }

  def listJob = {
    case class Query(projectId: Option[Long], tag: Boolean)

    val query = Jobs
      .dynamicSort("projectId", "asc")
      .dynamicQuery(Query(None, true))

    db.run(query.result).foreach { f =>
      f.map(m => println(m))
    }
  }

  def selectJob = {
    val name = "deploy"
    val ref = null
    val q = sql"select * from jobs j where name = '#$name'  ".as[JobsRow]
    db.run(q).flatMap { f =>
      Future(f.map(println(_)))
    }
  }

  def listJoin = {
    val q = Project.join(Jobs).on((p, j) => p.id === j.projectId)

    db.run(q.result).flatMap { f =>
      Future {
        f.groupBy(_._1).map { case (p, pj) => (p, pj.sortBy(_._2.id).headOption) }
      }
    }
  }


}
*/
