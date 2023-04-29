package web.app.springboot.boot;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import web.app.springboot.boot.model.User;
import web.app.springboot.boot.repo.UserRepository;
import web.app.springboot.boot.service.UserService;

@SpringBootApplication
public class BootApplication implements ApplicationRunner {
	private final UserService userService;

	public BootApplication(UserService userService) {
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		User user = new User("guest", "guestov", "guest@gmail.com");

		userService.addUser(user);
		userService.addUser(new User("user", "userov", "user@gmail.com"));
		userService.addUser(new User("admin", "adminov", "admin@gmail.com"));

		System.out.println("GET USER LIST: " + userService.getUserList().toString());

		System.out.println("GET USER BY ID = 1: " + userService.getUserById(1L).toString());
		System.out.println("DELETE USER BY ID = 1: " + userService.deleteUserById(1L));

		System.out.println("GET USER LIST: " + userService.getUserList().toString());

		user.setEmail("guestguest@gmail.com");
		System.out.println("CHANGE USER (email): " + userService.changeUser(user).toString());

		userService.deleteAllUsers();
		System.out.println("GET USER LIST AFTER DELETED: " + userService.getUserList());
	}
}
