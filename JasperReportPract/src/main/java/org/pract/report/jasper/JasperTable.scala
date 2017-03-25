package org.pract.report.jasper

import java.io.File
import java.util

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource
import net.sf.jasperreports.engine.{JREmptyDataSource, JasperFillManager, JasperPrint}
import org.apache.commons.io.FileUtils

/**
  * Created by ranjan on 25/3/17.
  */
class JasperTable {

  val directory = FileUtils.toFile(getClass.getClassLoader.getResource(""))

  def fillTable(): JasperPrint = {

    val userHomeDirectory: String = System.getProperty("user.home")
    /* Output file location */

    val outputFile: String = userHomeDirectory + File.separatorChar + "JasperTableExample.pdf"
    /* List to hold Items */

    val listItems: util.List[Item] = new util.ArrayList[Item]()
    /* Create Items */

    val iPhone: Item = new Item()
    iPhone.setName("iPhone 6S")
    iPhone.setPrice(65000.00)
    val iPad: Item = new Item()
    iPad.setName("iPad Pro")
    iPad.setPrice(70000.00)
    /* Add Items to List */

    listItems.add(iPhone)
    listItems.add(iPad)
    /* Convert List to JRBeanCollectionDataSource */

    val itemsJRBean: JRBeanCollectionDataSource =
      new JRBeanCollectionDataSource(listItems)
    /* Map to hold Jasper report Parameters */

    val parameters = new util.HashMap[String, AnyRef]()
    parameters.put("ItemDataSource", itemsJRBean)


        val jasperPrint = JasperFillManager.fillReport(
          getClass.getClassLoader.getResourceAsStream("template_Table.jasper"),
            parameters,
          new JREmptyDataSource())


    //JasperReporUtils.fillReport(FileUtils.getFile(directory,"template_Table.jasper").getAbsolutePath,parameters);

    jasperPrint


  }

}
