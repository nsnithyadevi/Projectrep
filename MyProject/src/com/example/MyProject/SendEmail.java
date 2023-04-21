
package com.example.MyProject;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;


public class SendEmail {

        public static void main(String[] args) {

            String to = "nsnithyadevi@gmail.com"; //Recipient email address
            String from = "nithyastns@gmail.com"; //Sender email address
            String host = "smtp.gmail.com"; //SMTP host for Gmail

            Properties properties = System.getProperties();
            properties.setProperty("mail.smtp.host", host);
            properties.setProperty("mail.smtp.port", "587");
            properties.setProperty("mail.smtp.starttls.enable", "true");
            properties.setProperty("mail.smtp.auth", "true");

            //Creating a session object

            Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("nithyastns@gmail.com", "zhuzcavdninjrhqx"); //set app spec password
                }
            });

            try {
                //Creating MimeMessage object
                MimeMessage message = new MimeMessage(session);
                //Set From Field: adding senders email to from field.
                message.setFrom(new InternetAddress(from));
                //Set To Field: adding recipient's email to To field.
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                //Set Subject: subject of the email
                message.setSubject("2This is the Subject Line!");
                //Now set the actual message
                message.setText("2This is actual message");

                //Send message
                Transport.send(message);
                System.out.println("Sent message successfully....");
            } catch (MessagingException mex) {
                mex.printStackTrace();
            }
        }
    }

