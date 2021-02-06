package controllers

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl
import javax.inject._
import models.{TaskListInMemoryModel, UserData}
import play.api.data._
import play.api.libs.json._
import play.api.mvc._
import play.api.i18n._

@Singleton
class TaskList3 @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def load = Action { implicit request =>
    Ok(views.html.version3Main())
  }

  implicit val userDataReads = Json.reads[UserData]

  def validate = Action { implicit request =>
    request.body.asJson.map { body =>
      Json.fromJson[UserData](body) match {
        case JsSuccess(userData, _) => {
          if (TaskListInMemoryModel.validateUser(userData.userName, userData.password)) {
            Ok(Json.toJson(true)).withSession("username" -> userData.userName, "csrfToken" -> play.filters.csrf.CSRF.getToken)
          } else {
            Ok(views.html.login2())
          }
        }
        case e@JsError(_) => Redirect(routes.TaskList3.load())
      }
    }.getOrElse(Redirect(routes.TaskList3.load()))
  }

  def data = Action {
    Ok(Json.toJson(Seq("a", "b", "c")))
  }
}
