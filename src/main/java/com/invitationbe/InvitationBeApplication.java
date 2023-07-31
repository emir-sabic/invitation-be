package com.invitationbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@ComponentScan(basePackages = {"com.invitationbe.*"})
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class InvitationBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvitationBeApplication.class, args);
	}

}
