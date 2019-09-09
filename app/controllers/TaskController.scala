package controllers

import javax.inject._
import play.api.mvc._

@Singleton
class TaskController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index = Action {
    Ok(views.html.index())
  }

  def taskList1 = Action {
    Ok("This works!")
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
