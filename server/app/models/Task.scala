package models

case class Task(id: Int, name: String)

object Task {
  private var taskList: List[Task] = List()

  def getAllTasks(): List[Task] = {
    taskList
  }

  def addTask(name: String) = {
    var newId = 0
    if (taskList.isEmpty) {
      newId = 1
    } else {
      newId = taskList.last.id + 1
    }
    taskList = taskList ++ List(Task(newId, name))
  }

  def deleteTask(taskId: Int) = {
    taskList = taskList.filterNot(_.id == taskId)
  }
}
