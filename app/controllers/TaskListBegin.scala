package controllers

import javax.inject._
import play.api.mvc._
import play.api.i18n._

@Singleton
class TaskListBegin @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def taskListBegin1: Action[AnyContent] = Action {
    val tasks = List("task 1", "task 2", "task 3")
    Ok(views.html.taskListBegin1(tasks))
  }
}
