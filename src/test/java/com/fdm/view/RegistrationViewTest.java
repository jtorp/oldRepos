package com.fdm.view;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;



import com.fdm.model.User;

public class RegistrationViewTest {

	RegistrationView regView;
	Scanner Scanner;
 
	@Before
	// you will need to create a String which contains all the users details,
	// separate the details with \n this represents a new line
	public void setUp() {
		regView = new RegistrationView();
		String details = "username\npassword\nfirstname\nlastname\nrole";
		
		Scanner scanner = new Scanner(new ByteArrayInputStream(
				details.getBytes()));// created new scanner, then
															// pass a new
															// ByteArrayInputStream
															// Object into its
															// constructor, and
															// pass your string
															// of details to the
															// ByteArrayInputStream’s
															// constructor
		regView.setScanner(scanner);

	}

	@Test
	public void testGetInputFromUser() {
		@SuppressWarnings("unused")
		User user = regView.getInput();
	}

	@Test
	public void testGetUsernameReturnsCorrectUsernameField() {
		User user = regView.getInput();
		assertEquals("username", user.getUsername());
	}

	@Test
	public void testGetPasswordReturnCorrectPasswordField() {
		User user = regView.getInput();
		assertEquals("password", user.getPassword());
	}

	@Test
	public void testGetFirstnameReturnsCorrectFnameField() {
		User user = regView.getInput();
		assertEquals("firstname", user.getFirstname());
	}

	@Test
	public void testGetLastnameReturnsCorrectLnameField() {
		User user = regView.getInput();
		assertEquals("lastname", user.getLastname());
	}
	/*@Test
	public void testGetRoleReturnsCorrectRoleField() {
		User user = regView.getInput();
		assertEquals(1, user.getRole());
	}*/
}
