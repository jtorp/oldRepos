package com.fdm.view;

import java.util.Scanner;
import com.fdm.actions.Request;
import com.fdm.model.User;

public class SysAdminView implements AdminOnlyView {
	private Request request;
	private Scanner scanner;

	// private SysAdmin sysadmin;

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public Request getInput() {

		User user = new User();
		System.out.println(" Enter 0 to setRole:  ");
		System.out.println(" Enter 1 to Ban User:  ");
		System.out.println(" Enter 1 to Restore Banned User ");
		System.out.println(" Enter 3 to Remove User");
	
		scanner = new Scanner(System.in);
		int option = ((scanner.nextInt()));
		request.get();

		if (option == 3) {

			System.out.println("Which user to remove? ");
			user.setUsername(scanner.nextLine());
		}
		request.setUser(user);
		return request;
	}

	public void display(String string) {

	}

}
