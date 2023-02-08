package eventmanagement.eventmanagement.service;

// Importing required classes

import eventmanagement.eventmanagement.controller.attendeeregistationcontroller;
import eventmanagement.eventmanagement.entity.attenderegistation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

    @Service
// Class
// Implementing EmailService interface
    public class attenderegistationimpl implements Registationservice {
        // Java Program to Illustrate Creation Of
// Service implementation class

        @Autowired private JavaMailSender javaMailSender;

        @Value("${spring.mail.username}") private String sender;





        @Override
        public ResponseEntity<String> sendSimpleMail(attenderegistation details) {
            // Try block to check for exceptions
            try {

                // Creating a simple mail message
                SimpleMailMessage mailMessage
                        = new SimpleMailMessage();

                // Setting up necessary details
                mailMessage.setFrom(sender);
                mailMessage.setTo(details.getEmail());
                mailMessage.setText(details.getDesricption());
                mailMessage.setSubject(details.getUrl());

                // Sending the mail
                javaMailSender.send(mailMessage);
                return new ResponseEntity<String>("mail send sucessfully", HttpStatus.OK);
            }

            // Catch block to handle the exceptions
            catch (Exception e) {
                return new ResponseEntity<String>("something went try again", HttpStatus.INTERNAL_SERVER_ERROR);
            }


        }
    }
