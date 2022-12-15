package com.ActiveDay.ris.Model;

public interface EmailService 
{
	boolean sendSimpleMail(String to, String subject, String text);

}
