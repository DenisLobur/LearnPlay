package models

case class User(email: String, name: String)


object User {

  def save(): Long = {
    -1
  }

}
