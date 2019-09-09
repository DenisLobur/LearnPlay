name := """/home/denys/projects/IdeaProjects/learnPlay/sampleApp"""

version := "1.0-SNAPSHOT"

lazy val root = project.in(file(".")).enablePlugins(PlayScala)
libraryDependencies += guice