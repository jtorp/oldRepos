package com.fdm.controller;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fdm.Exceptions.LoginException;
import com.fdm.actions.Login;
import com.fdm.model.User;
import com.fdm.model.storage.Storage;
import com.fdm.validators.LoginValidator;
import com.fdm.view.View;

public class LoginControllerTest {

	LoginController logcontroller;
	@Mock
	View mockview;
	@Mock
	Login mockLog;
	@Mock
	LoginValidator mocklogval;
	@Mock
	User mockuser;
	@Mock
	Storage mockstorage;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		logcontroller = new LoginController();
		logcontroller.setView(mockview);
		logcontroller.setLogin(mockLog);
		logcontroller.setLoginValidator(mocklogval);

	}

	@Test
	public void testControllerHandleMethodCallsGetInputMethodFromView()
			throws LoginException {
		logcontroller.handle();
		verify(mockview).getInput();
	}

	@Test
	public void testUserFromGetInputMethodIsPassedToValidateMethod()
			throws LoginException {
		when(mockview.getInput()).thenReturn(mockuser);
		logcontroller.handle();
		verify(mocklogval).validate(mockuser);
	}

	@Test
	public void testILoginuserMethodIsCalledIfUsernameIsValid()
			throws LoginException {
		when(mockview.getInput()).thenReturn(mockuser);
		logcontroller.handle();
		verify(mockLog).loginUser("");
	}

	@Test
	public void testIfRegisteuserMethodIsCalledIfUsernameIsInvalid()
			throws LoginException {
		when(mockview.getInput()).thenReturn(mockuser);
		doThrow(new LoginException("")).when(mocklogval).validate(mockuser);
		logcontroller.handle();
		verify(mockLog, times(0)).loginUser("");
	}
}
