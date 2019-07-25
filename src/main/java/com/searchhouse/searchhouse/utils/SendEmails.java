package com.searchhouse.searchhouse.utils;

import com.searchhouse.searchhouse.model.User;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.util.Properties;

public class SendEmails {

    private String username = "pguesssle@gmail.com";
    private String password = "mzfnpiawoeqcdnct";
    private Properties properties;

    private User user;

    public boolean sendMailtoUsers(HttpServletRequest request, User user, String token) {

        this.user = user;
        properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        String appUrl =  request.getScheme() + "://" + request.getServerName();

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("muarachmann@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(this.user.getEmail())
            );
            message.setSubject("Welcome "+ this.user.getNom()+ " "+ this.user.getPrenom() + " to Searchhouse");
            message.setText("Dear "+ this.user.getNom() + " "+ this.user.getPrenom() + "," +
                    "\n\nWelcome to searchhouse. Please click on the following link to activate your account "+ appUrl + "/register/activate/agent?token="+token);

            Transport.send(message);
            return true;

        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }


}
