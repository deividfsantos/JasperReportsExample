package br.com.deividsantos.jasper.service;

import net.sf.jasperreports.engine.*;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.HashMap;

@Service
public class PdfService {

    public String generate(HashMap<String, Object> dados, Resource pathReport) throws IOException, JRException {
        if (getJasper(pathReport) != null) {
            JasperPrint print = JasperFillManager.fillReport(getJasper(pathReport), dados, new JREmptyDataSource());
            if (print != null) {
                byte[] pdf = JasperExportManager.exportReportToPdf(print);
                return Base64.getEncoder().encodeToString(pdf);
            }
        }
        return "";
    }

    private InputStream getJasper(Resource pathReport) throws IOException {
        return pathReport.getInputStream();
    }
}
