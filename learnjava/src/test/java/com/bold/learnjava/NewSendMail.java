package com.bold.learnjava;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.bold.utility.MonitoringMail;
import com.bold.utility.TestConfig;


public class NewSendMail {

	public static void main(String[] args) throws AddressException, MessagingException {
		
		MonitoringMail m = new MonitoringMail();
		m.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody, TestConfig.attachmentPath, TestConfig.attachmentName);
	}

}
