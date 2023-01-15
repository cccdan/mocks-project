package com.skillsoft.mocks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class WeeklyReportsBatchJobTest {

    @Mock
    private EmailSender emailSenderMock;

    AutoCloseable closeable;

    @BeforeEach
    public void setupMocks() {
        closeable = openMocks(this);
    }

    @AfterEach
    public void releaseMocks() throws Exception {
        closeable.close();
    }

    @Test
    public void testGenerateWeeklyReport_singleRecipient() {

        WeeklyReportsBatchJob batchJob = new WeeklyReportsBatchJob(emailSenderMock);

        when(emailSenderMock.sendEmail("john@infomoto.com",
                "The Sales weekly report has been generated")).thenReturn(true);

        assertTrue(batchJob.generateWeeklyReport("Sales", "john@infomoto.com"));
    }

    @Test
    public void testGenerateWeeklyReport_multipleRecipients() {

        WeeklyReportsBatchJob batchJob = new WeeklyReportsBatchJob(emailSenderMock);

        when(emailSenderMock.sendEmailToMultipleRecipients(
                new String[]{ "john@infomoto.com", "julia@infomoto.com" },
                "The Revenues weekly report has been generated")).thenReturn(true);

        assertTrue(batchJob.generateWeeklyReport("Revenues",
                new String[] {"john@infomoto.com", "julia@infomoto.com"}));
    }

    @Test
    public void sendWeeklyReport_withAttachment() {

        WeeklyReportsBatchJob batchJob = new WeeklyReportsBatchJob(emailSenderMock);

        when(emailSenderMock.sendEmailWithAttachment(
                "john@infomoto.com",
                "The Profits weekly report has been generated",
                "Sales have been going up".getBytes())).thenReturn(true);

        assertTrue(batchJob.sendWeeklyReport("Profits", "john@infomoto.com"));
    }

}