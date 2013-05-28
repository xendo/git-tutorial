import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName = "git_training"
  val appVersion = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    jdbc,
    anorm
  )

  def customLessEntryPoints(base: File): PathFinder = (
    (base / "app" / "assets" / "stylesheets" / "bootstrap" * "bootstrap.less") +++
      (base / "app" / "assets" / "stylesheets" * "*.less"))


  val main = play.Project(appName, appVersion, appDependencies)
    .settings(lessEntryPoints <<= baseDirectory(customLessEntryPoints))


}
