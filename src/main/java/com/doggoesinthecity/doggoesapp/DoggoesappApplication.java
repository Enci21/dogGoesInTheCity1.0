package com.doggoesinthecity.doggoesapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;


@SpringBootApplication
public class DoggoesappApplication {

    public static void main(String[] args) {
        SpringApplication.run(DoggoesappApplication.class, args);
    }

    @Bean
    public SimpleMailMessage simpleMailMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText("Welcome on Doggoes in the city! \n\n " + "Thank you for the registration.\n" +
                "Please activate your account and click on the link below:\n" +
                "http://localhost:3000/activate/"
        );
        message.setSubject("Welcome on Doggoes in the city!");
        message.setFrom("DoggoesInTheCity");
        return message;
    }

    @Bean
    public JavaMailSender mailSender() {
        final String username = "doggoesinthecity@gmail.com";
        final String password = "vxmvkjsfgyghxlcw";

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername(username);
        mailSender.setPassword(password);
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        return mailSender;
    }

}
