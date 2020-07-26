package controllers

import javax.inject.{Inject, Singleton}
import play.api.mvc._

@Singleton
class Application @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index = Action { implicit request =>
    Ok("It works")
  }

  def product(prodType: String, prodNum: Int) = Action {
    Ok(s"Product type is: $prodType, product number is: $prodNum")
  }

  def randomNumber = Action {
    Ok(util.Random.nextInt(100).toString)
  }

  def randomString(length: Int) = Action {
    Ok(util.Random.nextString(length))
  }
}
