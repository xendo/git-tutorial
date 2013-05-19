package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

object Application extends Controller {

  def index = TODO

  def git = Action {
    
    val tasks = List(
        ("config","blablabla","% git config --global user.name \"Jerzy Zagorski\" \n" + 
        		"% git config --global user.email \"jerzy.zagorski@sabre.com\""),
        ("init", "creates git repository in current directory", "% git init"),
        ("clone","blablabla","% git clone url"),
        ("status","blablabla","% git status"),
        ("remote","blablabla","% git remote show origin"),
        ("add","blablabla","% git add . \n% git add url \n% git add -i"),
        ("commit","blablabla","% git commit -m \"commit message\" \n% git commit"),
        ("log","blablabla","% git commit -m \"commit message\" \n% git commit"),
        ("push","blablabla","% git push origin master"),
        ("diff","blablabla","blablabla"),
        ("pull","blablabla","blablabla"),
        ("fetch","blablabla","blablabla"),
        ("merge","blablabla","blablabla"))
    
    Ok(views.html.index(tasks, taskForm))
  }

  val taskForm = Form(
    tuple("label" -> nonEmptyText,
      "description" -> text))

}