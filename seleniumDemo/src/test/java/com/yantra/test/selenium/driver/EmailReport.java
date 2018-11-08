package com.yantra.test.selenium.driver;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.xml.XmlSuite;

import com.beust.testng.TestNG;

public class EmailReport  {
	public static void main(String a[]) throws Exception {
		EmailReport.sendMail("CSSP -TestNG Report -" + new Date(),
				"Hi,\n\tPlease download the attachement to view the TestNG report.\nThanks,\nQA team.", false, true,
				"test-output/html");	
	}

	public static void sendMail(String subject, String content, boolean isHtml, boolean hasAttachemnt,
			String attachmentDirectory) {
		System.out.println("------------sending email"+new Date());
		sendMail("srinivasanadhithya12@gmail.com","p.vijaykumar@finateltech.com", subject,
				content, isHtml, hasAttachemnt, attachmentDirectory);
	}

	public static void sendMail(String from, String toLsit, String subject, String content, boolean isHtml,
			boolean hasAttachemnt, String attachmentDirectory) {
		Session session = getSession();
		try {
			if (session == null) {
				System.out.println("Couldn't start session, Exiting..");
				return;
			}
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toLsit));
			message.setSubject(subject);
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(content);
			Multipart multipart = new MimeMultipart("mixed");
			multipart.addBodyPart(messageBodyPart);
			if (hasAttachemnt && attachmentDirectory != null) {
				try {
					String path = new File(attachmentDirectory).getAbsolutePath();
					File folder = new File(path);
					attachFile(folder,messageBodyPart,multipart);
				} catch (Exception ex) {
					System.out.println("Error getting attachment file");
				}
			}
			message.setContent(multipart);
			Transport.send(message);
			System.out.println("Done");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	private static void attachFile(File file,BodyPart messageBodyPart,Multipart multipart) throws MessagingException{
		if (file.isFile()) {
			messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(file);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(source.getName());
			multipart.addBodyPart(messageBodyPart);
		}
		else{
			for (File subFile : file.listFiles())
				attachFile(subFile, messageBodyPart, multipart);
		}		
	}
	
	private static Session getSession() {
		try {
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");

			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("srinivasanadhithya12@gmail.com",
							"keerthana@123");
				}
			});
			return session;
		} catch (Exception ex) {
			System.out.println(ex);return null;
		}
	}
}