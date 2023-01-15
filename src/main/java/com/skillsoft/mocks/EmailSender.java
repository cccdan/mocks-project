package com.skillsoft.mocks;

public class EmailSender {

    private String username;
    private String password;
    private String emailServer;

    public EmailSender(String username, String password, String emailServer) {
        this.username = username;
        this.password = password;
        this.emailServer = emailServer;
    }

    public boolean sendEmail(String toAddress, String emailText) {

        return true;
    }

    public boolean sendEmailToMultipleRecipients(String[] toAddresses, String emailText) {

        return true;
    }

    public boolean sendEmailWithAttachment(String toAddress, String emailText, byte[] attachmentBytes) {

        return true;
    }
}
