package com.Laboratory.Laboratory.MailAccess.Interfaces;

import java.util.Map;

public interface IMailAccess {

    /**
     * Sends a verification email to a laborant.
     *
     * @param from    the email address of the sender
     * @param to      the email address of the recipient
     * @param subject the subject of the email
     * @param text    the content of the email
     * @return true if the email is sent successfully, false otherwise
     */
    Boolean sendLaborantVerificationMail(String to, String subject, Map<String,Object> contentMap);
    void sendSimpleMessage(String to, String subject, String text);
}
