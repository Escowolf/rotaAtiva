package com.rotativa.usersapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication (exclude = {SecurityAutoConfiguration.class})
public class UsersapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersapiApplication.class, args);

	}
  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder() {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); 
    return encoder;
}

}
