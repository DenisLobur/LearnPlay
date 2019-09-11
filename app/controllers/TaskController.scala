package controllers

import javax.inject._
import models.TaskListInMemoryModel
import play.api.mvc._

@Singleton
class TaskController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def login = Action {
    Ok(views.html.login())
  }

  def validateLoginGet(userName: String, password: String) = Action {
    Ok(s"User $userName was logged with the password $password")
  }

  def validateLoginPost = Action { request =>
    val postVals = request.body.asFormUrlEncoded
    postVals.map { args =>
      val username = args("username").head
      val password = args("password").head
      if (TaskListInMemoryModel.validateUser(username, password)) {
        Redirect(routes.TaskController.taskList1())
      } else {
        Redirect(routes.TaskController.login())
      }
    }.getOrElse(Redirect(routes.TaskController.login()))
  }

  def createUser = Action { request =>
    val postVals = request.body.asFormUrlEncoded
    postVals.map { args =>
      val username = args("username").head
      val password = args("password").head
      if (TaskListInMemoryModel.createUser(username, password)) {
        Redirect(routes.TaskController.taskList1())
      } else {
        Redirect(routes.TaskController.login())
      }
    }.getOrElse(Redirect(routes.TaskController.login()))
  }

  def index = Action {
    Ok(views.html.index())
  }

  def taskList1 = Action {
    val username = "denis"
    val list = TaskListInMemoryModel.getTasks(username)
    Ok(views.html.taskList1(list))
  }

  def product(productType: String, productNum: Int) = Action {
    Ok(s"Product type is: $productType, product number is: $productNum")
  }

  //
  //  def tasks = Action {
  //    Ok(views.html.index(Task.getAllTasks()))
  //  }
  //
  //  def newTask = Action(parse.urlFormEncoded) {
  //    implicit request =>
  //      Task.addTask(request.body("taskName").head)
  //      Redirect(routes.TaskController.index())
  //  }
  //
  //  def deleteTask(id: Int) = Action {
  //    Task.deleteTask(id)
  //    Ok
  //  }
  //
  //  def newPage = Action {
  //    val content = Html("NEW and updated")
  //    Ok(views.html.main("My Home")(content))
  //  }

}
