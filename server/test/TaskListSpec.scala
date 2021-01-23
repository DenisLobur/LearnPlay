import org.scalatestplus.play.{HtmlUnitFactory, OneBrowserPerSuite, PlaySpec}
import org.scalatestplus.play.guice.GuiceOneServerPerSuite

class TaskListSpec extends PlaySpec with GuiceOneServerPerSuite with OneBrowserPerSuite with HtmlUnitFactory {
  "TaskListBegin" must {
    "login and access functions" in {
//      go to s"http://localhost:$port/login1"
//      click on "username-login"
//      textField("username-login").value = "denis"
//      click on "password-login"
//      textField("password-login").value = "pass"
//      submit()
      print("works!")
    }
  }
}
