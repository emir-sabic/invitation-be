package com.invitationbe.Services;


import com.invitationbe.Models.InvitationModel;
import com.invitationbe.Repository.InvitationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class InvitationService implements InvitationRepository {

    @Autowired private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}") private String sender;

    @Override
    public String sendMail(InvitationModel invitation) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            String msg = "Name: " + invitation.getName() + "\n"
                    + "Email: " + invitation.getEmail() + "\n"
                    + "Number of guests: " + invitation.getGuests() + "\n"
                    + "Is attending: " + invitation.getAttending() + "\n"
                    + "Message: " + invitation.getMessage();

            mailMessage.setFrom(sender);
            mailMessage.setTo(sender);
            mailMessage.setText(msg);
            mailMessage.setSubject("Invitation");

            javaMailSender.send(mailMessage);
            return "Mail was sent";
        }
        catch (Exception e){
            return "Mail sending error";
        }
    }
}
