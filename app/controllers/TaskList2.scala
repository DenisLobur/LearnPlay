package controllers

import javax.inject._
import models.TaskListInMemoryModel
import play.api.data._
import play.api.mvc._

@Singleton
class TaskList2 @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def load = Action { implicit request =>
    Ok(views.html.version2Main())
  }

  def login = Action {
    Ok(views.html.login2())
  }

  def validate(username: String, password: String) = Action {
    if (TaskListInMemoryModel.validateUser(username, password)) {
      val taskList = TaskListInMemoryModel.getTasks(username)
      Ok(views.html.taskList2(taskList)).withSession("username" -> username)
    } else {
      Ok(views.html.login2())
    }
  }

  def createUser(username: String, password: String) = Action {
    if (TaskListInMemoryModel.createUser(username, password)) {
      val taskList = TaskListInMemoryModel.getTasks(username)
      Ok(views.html.taskList2(taskList)).withSession("username" -> username)
    } else {
      Ok(views.html.login2())
    }
  }

  def deleteTask(index: Int) = Action { implicit req =>
    Ok("deleting")

  }

}
