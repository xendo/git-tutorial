package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

object Application extends Controller {

  def index = TODO

  def git = Action {
    val tasks = List(
        ("config","Get and set repository or global options","% git config --global user.name \"Jerzy Zagorski\" \n" +
        		"% git config --global user.email \"jerzy.zagorski@sabre.com\"\n% ssh-keygen -t rsa -C \"your_email@example.com\""),
        ("help", "", "% git help \n% git help command"),
        ("init", "Create an empty git repository or reinitialize an existing one", "% git init"),
        ("clone","Clone a repository into a new directory","% git clone $url"),
        ("remote","Manage set of tracked repositories","% git remote show \n% git remote show origin \n% git remote add origin $url"),
        ("status","Show the working tree status ","% git status"),
        ("add","Add file contents to the index","% git add . \n% git add url \n% git add -i"),
        ("commit","Record changes to the repository","% git commit -m \"commit message\" \n% git commit -a -m \"commit message\" \n% git commit"),
        ("log","Show commit logs","% git log\n% git log --oneline --graph"),
        ("diff","Show changes between commits, commit and working tree, etc ","% git diff \n% git diff branch_name ~different_branch_name \n% git diff branch_name..different_branch_name \n% git diff commit1#..commit2#"),
        ("pull","Fetch from and merge with another repository or a local branch","% git pull origin \n% git pull"),
        ("push","Update remote refs along with associated objects","% git push origin master"),
        ("fetch","Download objects and refs from another repository","% git fetch"),
        ("merge","Join two or more development histories together","% git merge branch_name \n% git merge branch1_name branch2_name ..."),
        ("branch","List, create, or delete branches","% git branch \n% git branch branch name\n% git branch -d branch name"),
        ("checkout","Checkout a branch or paths to the working tree","% git checkout branch_name \n% git checkout -b new_branch_name")
    )
    
    Ok(views.html.index(tasks, taskForm))
  }

  def gitResources = Action {
    Ok(views.html.git.resources())
  }

  def gitAdvantages = Action {
    val advantages = List(
      (1, "Git is fast",""),
      (2, "Everything is local",""),
      (3, "Cheap branches",""),
      (4, "Distributed workflow",""),
      (5, "Git is small","for the Mozilla project, 30x smaller)"),
      (6, "Git is safe","")
    )

    val disadvantages = List(
      (1, "Can be complicated",""),
      (2, "Cannot checkout only subtree","")
    )

    Ok(views.html.git.better(advantages, disadvantages))

    /*
    <li class><p class="text-success">Everything is local</p></li>
        <li class><p class="text-success">Cheap branches</p></li>
        <li class><p class="text-success">Distributed workflow</p></li>
        <li class><p class="text-error">More complicated than SVN</p></li>
     */
  }

  val taskForm = Form(
    tuple("label" -> nonEmptyText,
      "description" -> text))

}