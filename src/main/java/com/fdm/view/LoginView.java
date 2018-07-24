package com.fdm.view;

import com.fdm.model.User;
import com.fdm.model.factories.UserFactory;
import java.util.Scanner;

public class LoginView implements View {

	private Scanner scanner;

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;

	}

	public User getInput() {
		//User user = new User();
		User user = UserFactory.createUser(UserFactory.user);

		System.out.println("Your username : ");
		user.setUsername(scanner.nextLine());

		System.out.println("Your password : ");
		user.setPassword(scanner.nextLine());

		
		return user;

	}

	public void display(String string) {

	}

}



