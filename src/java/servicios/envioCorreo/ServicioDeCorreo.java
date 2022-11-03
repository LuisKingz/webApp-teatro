/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios.envioCorreo;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author lfern
 */
public class ServicioDeCorreo {

    public String Username = "teatro.sigot@gmail.com";
    public String PassWord = "teatrosigot500";

    public void SendMail(String subject, String To, String message) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Username, PassWord);
            }
        });

        try {
            Message mesage = new MimeMessage(session);
            mesage.setFrom(new InternetAddress(Username));
            mesage.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(To));
            mesage.setSubject(subject);
            mesage.setContent(message, "text/html");
            System.out.println(mesage.toString());
            Transport.send(mesage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
