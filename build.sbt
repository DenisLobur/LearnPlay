name := """/home/denys/projects/IdeaProjects/learnPlay/sampleApp"""

version := "1.0-SNAPSHOT"

lazy val root = project.in(file(".")).enablePlugins(PlayScala)
libraryDependencies += guice
libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.0"
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test