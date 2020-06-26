package models

import collection.mutable

object TaskListInMemoryModel {

  private val users = mutable.Map[String, String]("denis" -> "pass")
  private val tasks = mutable.Map[String, List[String]]("denis" -> List("wake up", "brush teeth", "have breakfast", "work", "go to bed"))

  def validateUser(username: String, password: String): Boolean = {
    users.get(username).contains(password)
  }

  def createUser(username: String, password: String): Boolean = {
    if (users.contains(username)) false else {
      users(username) = password
      true
    }
  }

  def getTasks(username: String): Seq[String] = {
    tasks.getOrElse(username, Nil)
  }

  def addTask(username: String, task: String): Unit = {
    tasks(username) = task :: tasks.getOrElse(username, Nil)
  }

  def removeTask(username: String, index: Int): Boolean = ???
}
