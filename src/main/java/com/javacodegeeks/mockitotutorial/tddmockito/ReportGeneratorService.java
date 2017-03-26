package com.javacodegeeks.mockitotutorial.tddmockito;

import java.util.Date;

/**
 * Created by Fisher on 3/25/2017.
 */
public class ReportGeneratorService {

    IReportGenerator reportGenerator;

    public ReportGeneratorService(IReportGenerator reportGenerator) {
        this.reportGenerator = reportGenerator;
    }

    public void generateReport(Date startDate, Date endDate, byte[] content) {

        ReportEntity report = new ReportEntity();
        report.setContent(content);
        report.setStartDate(startDate);
        report.setEndDate(endDate);

        reportGenerator.generateReport(report);

    }
}
