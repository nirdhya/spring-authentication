package com.simple.springauthentication;
import com.simple.springauthentication.domain.User;
import com.simple.springauthentication.dto.request.RoleRequestDTO;
import com.simple.springauthentication.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.ArrayList;


@SpringBootApplication
@EnableWebSecurity
public class SpringAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAuthenticationApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(UserService userService) {
		return args -> {

			userService.saveUser
					(new User(null, "Tony", "Stark911", "asdf@123", new ArrayList<>()));
			userService.saveUser
					(new User(null, "Stave", "stave999", "qwer@123", new ArrayList<>()));
			userService.saveUser
					(new User(null, "Natasha", "natasha60", "zxcv@123", new ArrayList<>()));

			userService.saveRole(new RoleRequestDTO("manager"));
			userService.saveRole(new RoleRequestDTO("admin"));
			userService.saveRole(new RoleRequestDTO("user"));

			userService.addRoleToUser("Stark911", "admin");
			userService.addRoleToUser("stave999", "manager");
			userService.addRoleToUser("natasha60","user");
		};
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
