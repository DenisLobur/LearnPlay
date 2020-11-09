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

}
