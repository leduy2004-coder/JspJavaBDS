package com.laptrinhjava.utils;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	static final String from = "leduy8762@gmail.com";
	static final String password = "kuotybpsrcscipda";

	/* static final String to = "doanthibichhongqueson@gmail.com"; */
	public static boolean sendEmail(String to, String tieuDe, String noidung) throws MessagingException {
		try {

			// Khai bao cac thuoc tinh
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP Host
			props.put("mail.smtp.port", "587"); // TLS Port
			props.put("mail.smtp.auth", "true"); // enable authentication
			props.put("mail.smtp.starttls.enable", "true"); //

			// create Authenticator
			Authenticator auth = new Authenticator() {

				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					// TODO Auto-generated method stub
					return new PasswordAuthentication(from, password);
				}

			};

			// Session
			Session session = Session.getInstance(props, auth);

			// create the mess
			MimeMessage msg = new MimeMessage(session);
			// Kiểu nội dung
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");

			// Người gửi
			msg.setFrom(new InternetAddress(from));

			// Người nhận
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));

			// tiêu đề
			msg.setSubject(tieuDe, "UTF-8");

			// Quy định ngày gửi
			msg.setSentDate(new Date());

			// Quy định email nhận phản hồi
			// msg.setReplyTo( InternetAddress.parse(from, false));

			// Nội dung
			msg.setContent(noidung, "text/html; charset=UTF-8");
			// send message
			Transport.send(msg);

			System.out.println("Message sent successfully");
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
