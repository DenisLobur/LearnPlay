package controllers

import javax.inject._
import play.api.mvc._
import play.api.i18n._

@Singleton
class TaskListBegin @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def login = Action {
    Ok(views.html.login1())
  }

  def validateLogin1(userName: String, password: String) = Action {
    Ok(s"User $userName was logged with the password $password")
  }

  def taskListBegin1: Action[AnyContent] = Action {
    val tasks = List("task 1", "task 2", "task 3")
    Ok(views.html.taskListBegin1(tasks))
  }

  def getProduct(prodName: String, prodNumber: Int) = Action {
    Ok(s"Product name is $prodName, product number is: $prodNumber")
  }
}
