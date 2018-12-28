package controllers

import java.io.File

import models.{Artist, User}
import play.api.libs.json.JsValue
import play.api.mvc.{Action, AnyContent, Controller}

object ArtistController extends Controller {

  def listArtists = Action {
    Ok(views.html.home(Artist.fetch))
  }

  def fetchArtistByName(name: String) = Action {
    Ok(views.html.home(Artist.fetchByName(name)))
  }

  def search(name: String, country: Option[String]) = Action {
    val result = country match {
      case Some(c) => Artist.fetchByNameOrCountry(name, c)
      case None => Artist.fetchByName(name)
    }
    if (result.isEmpty) {
      NoContent
    } else {
      Ok(views.html.home(result))
    }
  }

  def subscribe = Action(parse.json) {
    request =>
      val reqData: JsValue = request.body
      val emailId = (reqData \ "emailId").as[String]
      val interval = (reqData \ "interval").as[String]
      Ok(s"$emailId added to subscriber's list and will be notifies in $interval")
  }

  //TODO: finish user creation
  def createProfile = Action(parse.multipartFormData) {
    request =>
      val formData = request.body.asFormUrlEncoded
      val email: String = formData("email").head
      val name: String = formData("name").head
      //val userId: Long = User(email, name).save
      request.body.file("displayPic").map {
        picture =>
          val path = "/socialize/user/"
          if (!picture.filename.isEmpty) {
            //picture.ref.moveTo(new File(path + userId + ".jpeg"))
          }
          Ok("Successfully added user")
      }.getOrElse {
        BadRequest("Failed to add user")
      }
  }

  def save = Action(parse.text) {
    request =>
      Status(200)("Got: " + request.body)
  }

  def todoCheck =  {
    TODO
  }
}
