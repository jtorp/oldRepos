package com.fdm.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
	private User user;
	

	@Before
	public void setUp()  {
		user = new User();
		
		user.setUsername("username");
		user.setPassword("password");
		user.setFirstname("firstname");
		user.setLastname("lastname");
		user.setEnable(true);
		user.setRole(1);
		
	}

	@Test
	public void testGetUsernameReturnsUsername() {
		assertEquals("username", user.getUsername());
	}
	
	@Test
	public void testGetPasswordReturnsPassword() {
		assertEquals("password", user.getPassword());
	}
	
	@Test
	public void tesIsEnableMethodIsReturnedWhenTrueIsPassedInSetEnable() {
		assertEquals(true, user.isEnable());
	}
	
	@Test
	
	public void testGetLastname() {
		assertEquals("lastname", user.getLastname());
	}
	
	@Test
	public void testGetfirstname() {
		assertEquals("firstname", user.getFirstname());
	}
	
	@Test
	public void testGetRoleMethodWhen1IsPassedIn(){
		assertEquals(1,user.getRole());
	}
	

}
