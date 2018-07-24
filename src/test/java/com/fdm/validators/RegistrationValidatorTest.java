package com.fdm.validators;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fdm.Exceptions.RegistrationException;
import com.fdm.model.User;
import com.fdm.model.storage.Storage;

public class RegistrationValidatorTest {

	RegistrationValidator regvalidator;

	@Mock
	User mockUser;
	@Mock
	Storage mockStorage;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		regvalidator = new RegistrationValidator();
		regvalidator.setStorage(mockStorage);
	}

	@Test(expected = RegistrationException.class)
	// if already exists//
	public void testValidateThrowsExceptionIfUsernameAlreadyExistsInStorage()
			throws RegistrationException {
		when(mockStorage.get("username")).thenReturn(mockUser);
		when(mockUser.getUsername()).thenReturn("username");
		regvalidator.validate(mockUser);
	}

	@Test
	public void testValidateDoesNotThrowsExceptionIfUserDoesNotExistsInStorage()
			throws RegistrationException {

		when(mockStorage.get("username")).thenReturn(null);
		regvalidator.validate(mockUser);
	}

	/*@Test
	public void testRegistrationFormIsNotEmpty() throws RegistrationException {
		regvalidator.validate("myusername", "mypassword");

	}*/

}
