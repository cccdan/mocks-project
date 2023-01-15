package com.skillsoft.mocks;

public class WeeklyReportsBatchJob {

    private EmailSender emailSender;

    public WeeklyReportsBatchJob(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public boolean generateWeeklyReport(String reportType, String emailRecipient) {

        return emailSender.sendEmail(
                emailRecipient,
                String.format("The %s weekly report has been generated", reportType));

    }

    public boolean generateWeeklyReport(String reportType, String[] emailRecipients) {

        return emailSender.sendEmailToMultipleRecipients(
                emailRecipients,
                String.format("The %s weekly report has been generated", reportType));

    }

    public boolean sendWeeklyReport(String reportType, String emailRecipient) {

        String reportcopy = "Sales have been going up";

        return emailSender.sendEmailWithAttachment(
                emailRecipient,
                String.format("The %s weekly report has been generated", reportType),
                reportcopy.getBytes());

    }

}
