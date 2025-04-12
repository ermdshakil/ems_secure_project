package com.mohit_project.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailController {

	@Autowired
	private EmailService emailService;

	/*
	 * @PostMapping("/send") public String sendEmail(@RequestParam List<String>
	 * to, @RequestParam String subject, @RequestParam String body,
	 * 
	 * @RequestParam(defaultValue = "true") boolean track) {
	 * emailService.sendEmail(to, subject, body, track); return "Email sent to: " +
	 * to; }
	 */

	@PostMapping("/send")
	public String sendEmail(@RequestBody EmailRequest request) {
	    emailService.sendEmail(request.getTo(), request.getSubject(), request.getBody(), request.isTrack());
	    return "Email sent to: " + String.join(", ", request.getTo());
	}

}
