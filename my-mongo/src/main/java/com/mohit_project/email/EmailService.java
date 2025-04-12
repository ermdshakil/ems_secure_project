package com.mohit_project.email;


import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Value("${mail.username}")
    private String fromEmail;

    @Value("${mail.password}")
    private String password;

    @Value("${mail.smtp.host}")
    private String host;

    @Value("${mail.smtp.port}")
    private String port;

    @Value("${mail.smtp.auth}")
    private String auth;

    @Value("${mail.smtp.ssl.enable}")
    private String sslEnable;
    
	/*
	 * @Value("${mail.smtp.ssl.track}") private boolean track;
	 */

    private Session session;

    @jakarta.annotation.PostConstruct
    public void init() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", auth);
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.ssl.enable", sslEnable);
        props.put("mail.smtp.ssl.trust", host);

        session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });
    }

    public void sendSingleEmail(String toEmail, String subject, String body, boolean includeTracking) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);

            String htmlBody = "<p>" + body.replace("\n", "<br>") + "</p>";
            if (includeTracking) {
                htmlBody += "<img src='https://your-server.com/tracking-pixel?email=" + toEmail + "' width='1' height='1' style='display:none;'/>";
            }

            message.setContent(htmlBody, "text/html");
            message.setHeader("Disposition-Notification-To", toEmail);
            message.setHeader("Return-Receipt-To", toEmail);

            Transport.send(message);
            System.out.println("Email sent to: " + toEmail);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    
    public void sendEmail(List<String> recipients, String subject, String body, boolean track) {
        for (String to : recipients) {
            sendSingleEmail(to, subject, body, track);
        }
    }

	/*
	 * public void sendEmail(EmailDto emailDto) { for (String recipient :
	 * emailDto.getTo()) { sendSingleEmail(recipient, emailDto.getSubject(),
	 * emailDto.getBody(), track); } }
	 */
	
	

}

