package com.invitationbe.Controllers;


import com.invitationbe.Models.InvitationModel;
import com.invitationbe.Services.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping
@RestController("/api/invitation")
public class InvitationController {

    @Autowired private InvitationService invitationService;
    @PostMapping("/new")
    public String sendMail(@RequestBody InvitationModel invitation){
        String status = invitationService.sendMail(invitation);
        return status;
    }

}
