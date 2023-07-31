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

            String msg = "Ime: " + invitation.getName() + "\n"
                    + "Email: " + invitation.getEmail() + "\n"
                    + "Broj Gostiju: " + invitation.getGuests() + "\n"
                    + "Dolazi: " + invitation.getAttending() + "\n"
                    + "Poruka: " + invitation.getMessage();

            mailMessage.setFrom(sender);
            mailMessage.setTo(sender);
            mailMessage.setText(msg);
            mailMessage.setSubject("Pozivnica");

            javaMailSender.send(mailMessage);
            return "Mail was sent";
        }
        catch (Exception e){
            System.out.println(e);
            return "Mail sending error";

        }
    }
}
