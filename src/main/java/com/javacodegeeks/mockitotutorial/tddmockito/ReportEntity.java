package com.javacodegeeks.mockitotutorial.tddmockito;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by Fisher on 3/25/2017.
 */
public class ReportEntity {


    private Date startDate;
    private Date endDate;
    private byte[] content;

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public byte[] getContent() {
        return content;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ReportEntity{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", content=" + Arrays.toString(content) +
                '}';
    }
}
