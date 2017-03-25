package org.pract.report.jasper
import org.apache.commons.io.FileUtils

import scala.io.Source



/**
  * Created by ranjan on 25/3/17.
  */
object Test extends App{

  println("sdfsfsfsd")

  //println(Source.fromResource("template_Table.jasper"))

  println(FileUtils.getFile(FileUtils.toFile(getClass.getClassLoader.getResource("")),"template_Table.jasper"))


}
