import org.scalatest._
import org.scalatestplus.play._
import models._

class TaskListInMemoryModelSpec extends PlaySpec {
  "TaskListInMemoryModel" must {
    "do valid login for default user" in {
      TaskListInMemoryModel.validateUser("denis", "pass") mustBe (true)
    }
  }

  "reject login with wrong password" in {
    TaskListInMemoryModel.validateUser("denis", "password") mustBe (false)
  }

  "reject login with wrong username" in {
    TaskListInMemoryModel.validateUser("denizzz", password = "pass") mustBe (false)
  }

  "get corect default tasks" in {
    TaskListInMemoryModel.getTasks("denis") mustBe (List("wake up", "brush teeth", "have breakfast", "work", "go to bed"))
  }

  "create new user with no tasks" in {
    TaskListInMemoryModel.createUser("Mike", "qqq") mustBe (true)
    TaskListInMemoryModel.getTasks("Mike") mustBe (Nil)
  }

  "add new task for default user" in {
    TaskListInMemoryModel.addTask("denis", "testing")
    TaskListInMemoryModel.getTasks("denis") must contain("testing")
  }

  "remove task from default user" in {
    TaskListInMemoryModel.removeTask("denis", TaskListInMemoryModel.getTasks("denis").indexOf("wake up"))
    TaskListInMemoryModel.getTasks("denis") must not contain ("wake up")
  }
}
