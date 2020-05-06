package controllers

import javax.inject._
import play.api.mvc._
import play.api.i18n._

@Singleton
class TaskListBegin @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def taskListBegin1 = Action{
    Ok("This works!")
  }
}
