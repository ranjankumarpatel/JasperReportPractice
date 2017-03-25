package org.pract.report.jasper;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import java.util.Map;

/**
 * Created by ranjan on 25/3/17.
 */
public class JasperReporUtils {

    public static JasperPrint fillReport(String reportPath, Map<String,Object> parameters) {
        JasperPrint jasperPrint = null;
        try {
            jasperPrint= JasperFillManager.fillReport(reportPath, parameters,
                    new JREmptyDataSource());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jasperPrint;
    }


}
