package controllers

import javax.inject._
import models.TaskListInMemoryModel
import play.api.data._
import play.api.libs.json.Json
import play.api.mvc._

@Singleton
class TaskList3 @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def
  load = Action { implicit request =>
    Ok(views.html.version3Main())
  }

  def data = Action {
    Ok(Json.toJson(Seq("a", "b", "c")))
  }
}
