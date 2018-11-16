package com.bold.learnjava;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.annotations.Test;

import com.bold.utility.MonitoringMail;
import com.bold.utility.TestConfig;



public class TestMail {

	@Test
	public void sendMail() throws AddressException, MessagingException
	{
		MonitoringMail m = new MonitoringMail();
		m.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody, TestConfig.attachmentPath, TestConfig.attachmentName);
	}

}
