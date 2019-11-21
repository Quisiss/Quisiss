package model;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Mail {

    private final String username = "int303.quisiss@gmail.com";
    private final String password = "quisiss303";

    public boolean sendMail(String Email, String nameUser, String myMessage) {
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("Quisiss"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(Email)
            );
            message.setSubject("Test mail to show Sunny42");
            message.setText("Dear " + nameUser +","
                    + "\n\n " + myMessage);

            Transport.send(message);

            System.out.println("Done");
            return true;

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return false;
    }

}
