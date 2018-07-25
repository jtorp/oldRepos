package com.fdm.view;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import com.fdm.model.User;

public class LoginViewTest {

	LoginView loginView;
 	Scanner Scanner;

	@Before
	public void setUp() {
		loginView = new LoginView();
		String details = "username\npassword";

		Scanner scanner = new Scanner(new ByteArrayInputStream(
				details.getBytes()));
		loginView.setScanner(scanner);

	}

	@Test
	public void testGetUsername() {
		User user = loginView.getInput();
		assertEquals("username", user.getUsername());

	}

	@Test
	public void testGetPassword() {
		User user = loginView.getInput();
		assertEquals("password", user.getPassword());
	}
}
