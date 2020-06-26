package controllers

import javax.inject._
import models.TaskListInMemoryModel
import play.api.mvc._
import play.api.i18n._

@Singleton
class TaskListBegin @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index = Action {
    Ok(views.html.index("check"))
  }

  def login = Action {
    Ok(views.html.login1())
  }

  def validateLoginGet(userName: String, password: String) = Action {
    Ok(s"User $userName was logged with the password $password")
  }

  def validateLoginPost = Action { request =>
    val requestVals = request.body.asFormUrlEncoded
    requestVals.map { args =>
      val username = args("username").head
      val password = args("password").head
      if (TaskListInMemoryModel.validateUser(username, password)) {
        Redirect(routes.TaskListBegin.taskListBegin1()).withSession("username" -> username)
      } else {
        Redirect(routes.TaskListBegin.login())
      }
    }.getOrElse(Redirect(routes.TaskListBegin.login()))
  }

  def createUser = Action { request =>
    val postVals = request.body.asFormUrlEncoded
    postVals.map { args =>
      val username = args("username").head
      val password = args("password").head
      if (TaskListInMemoryModel.createUser(username, password)) {
        Redirect(routes.TaskListBegin.taskListBegin1()).withSession("username" -> username)
      } else {
        Redirect(routes.TaskListBegin.login())
      }
    }.getOrElse(Redirect(routes.TaskListBegin.login()))
  }

  def taskListBegin1: Action[AnyContent] = Action { request =>
    val usernameOption = request.session.get("username")
    usernameOption.map { username =>
      val list = TaskListInMemoryModel.getTasks(username)
      Ok(views.html.taskListBegin1(list))
    }.getOrElse(Redirect(routes.TaskListBegin.login()))
  }

  def getProduct(prodName: String, prodNumber: Int) = Action {
    Ok(s"Product name is $prodName, product number is: $prodNumber")
  }

  def logout = Action {
    Redirect(routes.TaskListBegin.login()).withNewSession
  }
}
