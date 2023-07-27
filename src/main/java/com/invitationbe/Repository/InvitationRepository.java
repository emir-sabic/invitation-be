package com.invitationbe.Repository;

import com.invitationbe.Models.InvitationModel;

public interface InvitationRepository {

    String sendMail(InvitationModel invitation);
}
