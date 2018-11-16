package com.bold.utility;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;


public class MailSend {
	//public static Logger log;


	public static Logger log = Logger.getLogger("devpinoyLogger");

	@Test
	public void sendMail() throws AddressException, MessagingException{
		try {
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.socketFactory.fallback", "true");
			props.put("mail.smtp.port", "465");
			props.put("mail.smtp.connectiontimeout", "20000");
			props.put("mail.smtp.timeout", "20000");
			props.put("mail.smtp.starttls.enable", "true");

			log.debug("Mail properties loaded");

			Authenticator passuth = new javax.mail.Authenticator() {protected PasswordAuthentication getPasswordAuthentication() {return new PasswordAuthentication("authprovidercdtestcase2@gmail.com", "authcd@321");}};

			Session session = Session.getInstance(props,passuth);
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("authprovidercdtestcase2@gmail.com"));
			message.addHeader("Content-type", "application/zip; charset=UTF-8");
			message.addHeader("format", "flowed");
			message.addHeader("Content-Transfer-Encoding", "8bit");
			message.setSubject("Test Message " );
			message.setSentDate(new Date());
			//File htmlContent = new File(System.getProperty("user.dir") + File.separator + "target//surefire-reports//Suite//");
			//message.setContent(FileUtils.readFileToString(htmlContent,"utf-8"),"text/html; charset=utf-8");
			InternetAddress[] internetAddresses = new InternetAddress[1];
			for (int i = 0; i < internetAddresses.length; i++) {
				internetAddresses[i] = new InternetAddress("vishal.manave@bold.com");
			}
			String msg = "<div style=\"color:black;\">Jai Mata Di</div>";
			message.setContent(msg, "text/html; charset=utf-8");
			message.setRecipients(Message.RecipientType.TO, internetAddresses);
			Transport.send(message);
			System.err.println("Mail Sent successfully....");
		}
		catch(Exception e) {
			System.err.println(e);
		}
	}
}
