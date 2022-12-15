package com.ActiveDay.ris.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public boolean sendSimpleMail(String to, String subject, String text) 
	{
		try {
			SimpleMailMessage message = new SimpleMailMessage(); 
        	message.setFrom("personalcomputer.xd.omg@gmail.com");
        	message.setTo(to); 
        	message.setSubject(subject); 
        	message.setText(text);
        	emailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
        
        return true;
    }
}
