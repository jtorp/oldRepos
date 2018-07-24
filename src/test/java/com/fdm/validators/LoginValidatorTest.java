package com.fdm.validators;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fdm.Exceptions.LoginException;
import com.fdm.model.User;
import com.fdm.model.storage.Storage;

public class LoginValidatorTest {

	LoginValidator logvalidator;
	@Mock
	User mockUser;
	@Mock
	User mockStoredUser;
	@Mock
	Storage mockStorage;

	@Before
	public void setUp() {
		logvalidator = new LoginValidator();
		MockitoAnnotations.initMocks(this);
		logvalidator.setStorage(mockStorage);
	}

	@Test(expected = LoginException.class)
	public void testValidateMethodThrowsExceptionIfUserDoesNotExistsInStorage()
			throws LoginException {
		when(mockStorage.get("username")).thenReturn(null);
		logvalidator.validate(mockUser);

	}

	@Test(expected = LoginException.class)
	public void testValidateMethodThrowsLoginExceptionWhenWrongPasswordEntered()
			throws LoginException {
		when(mockStorage.get("username")).thenReturn(mockStoredUser);
		when(mockStoredUser.getUsername()).thenReturn("username");
		when(mockStoredUser.getPassword()).thenReturn("password");
		when(mockUser.getUsername()).thenReturn("username");
		when(mockUser.getPassword()).thenReturn("wrong Password");
		logvalidator.validate(mockUser);
	}

	@Test
	public void testValidateMethodBothUsernameAndPassWordAreCorrect()
			throws LoginException {
		when(mockStorage.get("username")).thenReturn(mockStoredUser);
		when(mockStoredUser.getUsername()).thenReturn("username");
		when(mockStoredUser.getPassword()).thenReturn("password");
		when(mockUser.getUsername()).thenReturn("username");
		when(mockUser.getPassword()).thenReturn("password");
		logvalidator.validate(mockUser);
	}
}
