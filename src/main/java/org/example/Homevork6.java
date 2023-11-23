package org.example;

import java.util.HashMap;
import java.util.Map;

public class Homevork6 {

    // Интерфейс для создания отчета
    interface ReportCreator {
        byte[] createReport(Document document);
    }

    // Реализация интерфейса для создания PDF-отчета
    static class PdfReportCreator implements ReportCreator {
        public byte[] createReport(Document document) {
// Логика создания PDF-отчета
            return null;
        }
    }

    // Реализация интерфейса для создания JSON-отчета
    static class JsonReportCreator implements ReportCreator {
        public byte[] createReport(Document document) {
// Логика создания JSON-отчета
            return null;
        }
    }

    // Реализация интерфейса для создания XML-отчета
    static class XmlReportCreator implements ReportCreator {
        public byte[] createReport(Document document) {
// Логика создания XML-отчета
            return null;
        }
    }

    static class ReportService {
        private Map<String, ReportCreator> reportCreators;

        public ReportService() {
            reportCreators = new HashMap<>();
            reportCreators.put("pdf", new PdfReportCreator());
            reportCreators.put("json", new JsonReportCreator());
            reportCreators.put("xml", new XmlReportCreator());
        }

        public byte[] createReport(Document document, String reportType) {
            // Получаем нужного создателя отчета по типу отчета
            ReportCreator reportCreator = reportCreators.get(reportType);

            if (reportCreator == null) {
                throw new UnsupportedOperationException("Unsupported report type");
            }

            // Создаем отчет с использованием соответствующего создателя
            return reportCreator.createReport(document);
        }

    }

    static class Document {
        private long id;
        private String number;
// ...
    }

    public static void main(String[] args) {
        ReportService reportService = new ReportService();
        Document document = new Document();
        String reportType = "pdf";

        byte[] report = reportService.createReport(document, reportType);

// Дальнейшие действия с отчетом


    }
}
