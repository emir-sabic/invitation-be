package com.invitationbe.Controllers;


import com.invitationbe.Models.InvitationModel;
import com.invitationbe.Services.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/invitation")
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class InvitationController {

    @Autowired private InvitationService invitationService;
    @PostMapping("/new")
    public String sendMail(@RequestBody InvitationModel invitation){
        String status = invitationService.sendMail(invitation);
        System.out.println("backend");
        return status;
    }

}
