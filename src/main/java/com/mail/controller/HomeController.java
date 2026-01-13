package com.mail.controller;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController 
{
	@Autowired
	private JavaMailSender jms;
	
	@GetMapping("/userRegister")
	@Scheduled(fixedRate = 3000)
	//@Scheduled(cron = "* * * * * *")
	public ResponseEntity<String> getMsg()
	{
		System.out.println("THIS IS MAIL SENDER API.....");
		
//		============SIMPLE MESSAGE=======================
//		SimpleMailMessage smp = new SimpleMailMessage();
//		smp.setTo("nihaabk@gmail.com");
//		smp.setSubject("Mail Testing.......");
//		smp.setCc("nihaabk@gmail.com");
//		smp.setText("Welocome to our website....");
//		jms.send(smp);
		
		
//		==========MIME MESSAGE===========================
		
		
		MimeMessage mimeMessage = jms.createMimeMessage();
		try {
			MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
			
			helper.setTo("nihaabk@gmail.com");
			helper.setSubject("Mime Message");
			helper.setText("<!DOCTYPE html>\r\n"
						+ "<html lang=\"en\">\r\n"
						+ "<head>\r\n"
						+ "    <meta charset=\"UTF-8\">\r\n"
						+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
						+ "    <title>My Free HTML Page</title>\r\n"
						+ "    <!-- You can link external CSS files here if needed -->\r\n"
						+ "    <!-- <link rel=\"stylesheet\" href=\"styles.css\"> -->\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "    <header>\r\n"
						+ "        <h1>Welcome to My Website</h1>\r\n"
						+ "    </header>\r\n"
						+ "    \r\n"
						+ "    <nav>\r\n"
						+ "        <a href=\"#\">Home</a> | \r\n"
						+ "        <a href=\"#\">About</a> | \r\n"
						+ "        <a href=\"#\">Contact</a>\r\n"
						+ "    </nav>\r\n"
						+ "\r\n"
						+ "    <main>\r\n"
						+ "        <h2>Main Content Section</h2>\r\n"
						+ "        <p>This is where your primary content goes. You can add text, images, and other elements here.</p>\r\n"
						+ "    </main>\r\n"
						+ "\r\n"
						+ "    <footer>\r\n"
						+ "        <p>&copy; 2025 My Website</p>\r\n"
						+ "    </footer>\r\n"
						+ "\r\n"
						+ "    <!-- You can link external JavaScript files here if needed -->\r\n"
						+ "    <!-- <script src=\"script.js\"></script> -->\r\n"
						+ "</body>\r\n"
						+ "</html>\r\n"
						+ "", true);
			
			helper.addAttachment("My Image", new File("C:\\Users\\nihaa\\OneDrive\\Desktop\\Google Dark Mode.jpg"));
		
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		jms.send(mimeMessage);
		
//		String msg = null;
//		msg.toLowerCase();
		
		return ResponseEntity.ok("Mail Sent....");
	}
}
