package com.norialertapp.service;

/**
 * Email service
 */
public interface EmailService {

	public void sendTextMail(String from, String to, String cc, String subject,String msg);
}