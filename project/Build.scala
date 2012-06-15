import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "play-oadr2-model"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
    	//not certain of the .org is necessary
   		"org.hibernate" % "hibernate-entitymanager" % "4.1.4.Final"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
   	  //added to include the oadr2.model library to be referenceable(sp?) in the views package
      templatesImport += "org.enernoc.open.oadr2.model._"    
    )

}