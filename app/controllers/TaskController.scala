package controllers

import models.Task
import play.api.mvc._
import play.twirl.api.Html

object TaskController extends Controller {

  def index = Action {
    Redirect(routes.TaskController.tasks())
  }

  def tasks = Action {
    Ok(views.html.index(Task.getAllTasks()))
  }

  def newTask = Action(parse.urlFormEncoded) {
    implicit request =>
      Task.addTask(request.body("taskName").head)
      Redirect(routes.TaskController.index())
  }

  def deleteTask(id: Int) = Action {
    Task.deleteTask(id)
    Ok
  }

  def newPage = Action {
    val content = Html("NEW and updated")
    Ok(views.html.main("My Home")(content))
  }

}
