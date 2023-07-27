package com.invitationbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class InvitationBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvitationBeApplication.class, args);
	}

}
