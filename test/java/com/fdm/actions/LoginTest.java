package com.fdm.actions;


import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fdm.model.User;
import com.fdm.model.storage.Storage;


public class LoginTest {
	
	Login login;
	@Mock
	Storage mockStorage;
	@Mock
	User mockUser;
	

	@Before
	public void setUp() {
		login = new Login();
		MockitoAnnotations.initMocks(this);
		login.setStorage(mockStorage);
		
	}

	@Test
	public void testThatUserLoginCallsStorageMethod() {
	
		login.loginUser("username");
		verify(mockStorage).get("username");
		
	}

}
