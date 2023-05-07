package com.example.aviation.service;


import com.example.aviation.domain.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class BookingService {
    @Autowired
    JavaMailSender javaMailSender;

    public String sendEmail(Booking booking, String mailId) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("vtfstiv@gmail.com");
        message.setTo(mailId);
        message.setSubject("Booking Email");
        message.setText("Successfull Booking With id: " + booking.getId() + ",  Passegers: " + booking.getPassengers().size() + ",  Departue Details: " + booking.getLeavingdate());

        javaMailSender.send(message);

        return "Booking Mail was sent successfully";
    }

}
