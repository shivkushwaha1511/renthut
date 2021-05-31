package utils;

import java.util.Properties;

import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.Transport;

public class EmailSender {
	public static void sendEmail(String who,String subject,String message) {
		Properties prop = new Properties();
		prop.setProperty("mail.transport.protocol","smtp");
		prop.setProperty("mail.smtp.auth","true");
		prop.setProperty("mail.smtp.starttls.enable","true");
		prop.setProperty("mail.smtp.host","smtp.gmail.com");
		prop.setProperty("mail.smtp.port","587");
		
		Session session = Session.getInstance(prop,new EmailAuthenticator());
		
		MimeMessage mime = new MimeMessage(session);
		
		try {
			mime.setFrom("testmail15112000@gmail.com");
			mime.setRecipients(RecipientType.TO, who);
			mime.setSubject(subject);
			mime.setContent(message,"text/html");
			Transport.send(mime);
		}catch(MessagingException e) {
			e.printStackTrace();
		}
	}
}

class EmailAuthenticator extends Authenticator{
	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("renthut2021@gmail.com","RentHut@2021");
	}
}