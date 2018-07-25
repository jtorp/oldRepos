package com.fdm.controller;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fdm.Exceptions.RegistrationException;
import com.fdm.actions.Register;
import com.fdm.model.User;
import com.fdm.model.storage.Storage;
import com.fdm.validators.RegistrationValidator;
import com.fdm.view.RegistrationView;

public class RegistrationControllerTest {

	// creating mocks from all classes//
	RegistrationController regcontroller;
	@Mock
	Register mockRegister;
	@Mock
	RegistrationView mockView;
	@Mock
	RegistrationValidator mockregValidator;
	@Mock
	Storage mockStorage;
	@Mock
	User mockUser;

	@Before
	public void setUp() {

		regcontroller = new RegistrationController();
		MockitoAnnotations.initMocks(this);

		regcontroller.setView(mockView);
		regcontroller.setVal(mockregValidator);
		regcontroller.setReg(mockRegister);

	}

	@Test
	public void testControllerHandleMethodCallsGetInputMethodFromView()
			throws RegistrationException {
		regcontroller.handle();
		verify(mockView, times(1)).getInput();
	}

	@Test
	public void testUserReturnedFromGetInputMethodIsPassedToValidateMethod()
			throws RegistrationException {
		when(mockView.getInput()).thenReturn(mockUser);
		regcontroller.handle();
		verify(mockregValidator, times(1)).validate(mockUser);

	}

	@Test
	public void testIfUserDoesNotExistInStorageRegisterUserMethodIsCalled()
			throws RegistrationException {
		when(mockView.getInput()).thenReturn(mockUser);
		regcontroller.handle();
		verify(mockRegister).registerUser(mockUser);

	}

	@Test
	public void testIfUserExistInStorageThenValidateMethodThrowsExceptionAndRegisterUserMethodIsCalled()
			throws RegistrationException {
		when(mockView.getInput()).thenReturn(mockUser);
		doThrow(new RegistrationException("")).when(mockregValidator).validate(
				mockUser);
		regcontroller.handle();
		verify(mockRegister, times(0)).registerUser(mockUser);
	}

}
