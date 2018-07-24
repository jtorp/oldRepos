package com.fdm.view;

import com.fdm.model.User;
import com.fdm.model.factories.UserFactory;
import java.util.Scanner;

public class RegistrationView implements View {

	private Scanner scanner;

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;

	}

	public User getInput() {
		User user = UserFactory.createUser(UserFactory.user);

		System.out.println("Type username : ");
		user.setUsername(scanner.nextLine());

		System.out.println("Type password : ");
		user.setPassword(scanner.nextLine());

		System.out.println("Type firstname : ");
		user.setFirstname(scanner.nextLine());

		System.out.println("Type lastname : ");
		user.setLastname(scanner.nextLine());

		return user;

	}

	public void display(String string) {

	}

}
