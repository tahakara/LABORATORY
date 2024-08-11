package com.Laboratory.Laboratory.Services;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.Laboratory.Laboratory.MailAccess.Interfaces.IMailAccess;
import com.Laboratory.Laboratory.Services.Interfaces.IMailService;

@Service
public class MailManager implements IMailService {
    private final IMailAccess mailAccess;

    public MailManager(IMailAccess mailAccess) {
        this.mailAccess = mailAccess;
    }

    @Override
    public Boolean sendLaborantVerificationMail(String to, String subject, Map<String,Object> contentMap) {
        return mailAccess.sendLaborantVerificationMail(to, subject, contentMap);
    }

    @Override
    public void sendSimpleMessage(String to, String subject, String text) {
        mailAccess.sendSimpleMessage(to, subject, text);
    }
}
