package com.javacodegeeks.mockitotutorial.tddmochito;

import com.javacodegeeks.mockitotutorial.tddmockito.IReportGenerator;
import com.javacodegeeks.mockitotutorial.tddmockito.ReportEntity;
import com.javacodegeeks.mockitotutorial.tddmockito.ReportGeneratorService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

/**
 * Created by Fisher on 3/25/2017.
 */
//@RunWith(MockitoJUnitRunner.class)
public class ReportGeneratorServiceTest {

    @InjectMocks
    private ReportGeneratorService reposrtGeneratorService;
    @Mock
    private IReportGenerator reportGenerator;
    // capture argument values
    @Captor
    private ArgumentCaptor<ReportEntity> reportCaptor;

    @Before
    public void setUp(){
        // initializes objects annotated with Mockito annotations for given test class
        // we don't need to need to use @RunWith(MockitoJUnitRunner.class)
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test(){

        Calendar startDate = Calendar.getInstance();
        startDate.set(2016,11,25);
        Calendar endDate = Calendar.getInstance();
        endDate.set(9999,12,31);
        String reportContent = "Report Content";
        reposrtGeneratorService.generateReport(startDate.getTime(),endDate.getTime(),reportContent.getBytes());

        // we don't have the ReportEntity, so capture it here and compare the value to verify the logic
        Mockito.verify(reportGenerator).generateReport(reportCaptor.capture());

        ReportEntity report = reportCaptor.getValue();

        System.out.println(report);

        assertEquals(116,report.getStartDate().getYear());
        assertEquals(11,report.getStartDate().getMonth());
        assertEquals(25,report.getStartDate().getDate());

        assertEquals(8100,report.getEndDate().getYear());
        assertEquals(0,report.getEndDate().getMonth());
        assertEquals(31,report.getEndDate().getDate());

        assertEquals("Report Content", new String(report.getContent()));

    }

}
