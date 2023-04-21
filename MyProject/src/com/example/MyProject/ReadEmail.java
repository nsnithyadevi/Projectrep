package com.example.MyProject;


import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import java.util.Properties;

public class ReadEmail {

        public static void main(String[] args) throws Exception {

            // Mail server configuration
            String host = "smtp.gmail.com";
            String username = "nithyastns@gmail.com";
            String password = "zhuzcavdninjrhqx";

            // Connect to the mail server
            Properties props = new Properties();
            props.setProperty("mail.store.protocol", "imaps");
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            store.connect(host, username, password);

            // Open the INBOX folder
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            // Get the messages
            Message[] messages = inbox.getMessages(1,2); //get first and second message

            // Print first and second message

            for (Message message : messages) {
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("Body: " + message.getContent().toString());
            }

            // Close the folder and store
            inbox.close(false);
            store.close();
        }
    }

