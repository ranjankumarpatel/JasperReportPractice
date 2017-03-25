package org.pract.report.jasper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class JasperTableExample {

	public static void main(String[] args) {
		try {
			/* User home directory location */
			final String userHomeDirectory = System.getProperty("user.home");
			/* Output file location */
			final String outputFile = userHomeDirectory + File.separatorChar + "JasperTableExample.pdf";

			/* List to hold Items */
			final List<Item> listItems = new ArrayList<Item>();

			/* Create Items */
			final Item iPhone = new Item();
			iPhone.setName("iPhone 6S");
			iPhone.setPrice(65000.00);

			final Item iPad = new Item();
			iPad.setName("iPad Pro");
			iPad.setPrice(70000.00);

			/* Add Items to List */
			listItems.add(iPhone);
			listItems.add(iPad);

			/* Convert List to JRBeanCollectionDataSource */
			final JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(listItems);

			/* Map to hold Jasper report Parameters */
			final Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("ItemDataSource", itemsJRBean);

			/*
			 * Using compiled version(.jasper) of Jasper report to generate PDF
			 */
			final JasperPrint jasperPrint = JasperFillManager.fillReport(
					JasperTableExample.class.getClassLoader().getResourceAsStream("template_Table.jasper"), parameters,
					new JREmptyDataSource());

			/* outputStream to create PDF */
			final OutputStream outputStream = new FileOutputStream(new File(outputFile));
			/* Write content to PDF file */
			JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

			System.out.println("File Generated");
		} catch (final JRException ex) {
			ex.printStackTrace();
		} catch (final FileNotFoundException ex) {
			ex.printStackTrace();
		}
	}

}
