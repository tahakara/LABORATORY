package com.Laboratory.Laboratory.MailAccess;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.Laboratory.Laboratory.MailAccess.Interfaces.IMailAccess;

import jakarta.mail.internet.MimeMessage;

@Component
public class MyMailSender implements IMailAccess {

    @Value("${spring.mail.noreplysender}")
    private String noReplyLabSender;

    @Value("${app.domain}")
    private String appDomain;
    
    @Value("${app.support.mail}")
    private String supportMail;

    @Value("${app.logo.url}")
    private String logoUrl;
    
    @Autowired
    private JavaMailSender emailSender;

    public String readLaborantVerificaitonHTMLTemplate(String filePath, String laborantName, String inLine1, String inLine2, String senderDepartment) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        // Dosyaya sınıf yolu üzerinden erişim sağla
        InputStream inputStream = getClass().getResourceAsStream(filePath);

        if (inputStream != null) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    contentBuilder.append(line);
                    contentBuilder.append(System.lineSeparator());
                }
            }
        } else {
            throw new IOException("Dosya bulunamadı: " + filePath);
        }

        String htmlContent = contentBuilder.toString();
        htmlContent = htmlContent.replace("{logo_url}", this.logoUrl);
        htmlContent = htmlContent.replace("{support_mail}", this.supportMail);
        htmlContent = htmlContent.replace("{app_domain}", this.appDomain);
        
        if (laborantName != null) {
            htmlContent = htmlContent.replace("{laborant_name}", laborantName);
        }
        if (inLine1 != null) {
            htmlContent = htmlContent.replace("{inline_1}", inLine1);
        }
        if (inLine2 != null) {
            htmlContent = htmlContent.replace("{inline_2}", inLine2);    
        }
        if (senderDepartment != null) {
            htmlContent = htmlContent.replace("{sender_department}", senderDepartment);
        }

        return htmlContent;
    }


    @SuppressWarnings("null")
    public void sendSimpleMessage(String to, String subject, String text) {

        MimeMessage message = emailSender.createMimeMessage();
        String htmlContent = "dummy";
        try {
            htmlContent = readLaborantVerificaitonHTMLTemplate("./laborantVerificationMail.html", "laborantName", "inLine1", "inLine2", "senderDepartment");
            MimeMessageHelper helper = new MimeMessageHelper(message, true); // true parametresi HTML içeriği olduğunu belirtir
            helper.setFrom(this.noReplyLabSender);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(htmlContent, true); // true parametresi HTML içeriği olduğunu belirtir
            emailSender.send(message);
        } catch (Exception e) {
            System.err.println(e);
        }

       

    }

	@SuppressWarnings("null")
    @Override
	public Boolean sendLaborantVerificationMail(String to, String subject, Map<String,Object> contentMap) {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            String htmlContent = "dummy";

            String laborantName = contentMap.get("laborantName") != null ? (String) contentMap.get("laborantName") : "Laborantımız" ;
            String inLine1 = contentMap.get("inLine1") != null ? (String) contentMap.get("inLine1") : "Aşağıdaki linke tıklayarak hesabınızı doğrulayabilir ve kullanıma başlayabilirsiniz.";
            String inLine2 = contentMap.get("verificationToken") != null ? "https://" + this.appDomain + "/laborant/verification?verificationToken=" + (String) contentMap.get("verificationToken") : "Eğer bu işlemi siz yapmadıysanız lütfen bize bildirin.";
            String senderDepartment = contentMap.get("senderDepartment") != null ? (String) contentMap.get("senderDepartment") : null;

            htmlContent = readLaborantVerificaitonHTMLTemplate("./laborantVerificationMail.html", laborantName, inLine1, inLine2, senderDepartment);
            
            MimeMessageHelper helper = new MimeMessageHelper(message, true); // true parametresi HTML içeriği olduğunu belirtir
            if (!(this.noReplyLabSender == null || this.noReplyLabSender.isEmpty() || to == null || to.isEmpty() || subject == null || subject.isEmpty() || htmlContent == null || htmlContent.isEmpty())){
                helper.setFrom(this.noReplyLabSender);
                helper.setTo(to);
                helper.setSubject(subject);
                helper.setText(htmlContent, true); // true parametresi HTML içeriği olduğunu belirtir
                emailSender.send(message);
                return true;
            }
            throw new Exception("Missing Paramaters for sending mail.");
        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
	}

}
