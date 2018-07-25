package com.fdm.actions;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fdm.model.User;
import com.fdm.model.storage.Storage;

public class RestoreBannedUserTest {

	RestoreBannedUser restoreUser;

	@Mock
	User mockUser;
	@Mock
	Storage mockStorage;
	@Mock
	Request mockRequest;

	@Before
	public void setUp() {
		restoreUser = new RestoreBannedUser();
		MockitoAnnotations.initMocks(this);
		restoreUser.setStorage(mockStorage);

	}

	@Test
	public void testExecuteRestoreMethodCallsSetEnableUserMethod() {
		when(mockRequest.getUser()).thenReturn(mockUser);
		when(mockUser.getUsername()).thenReturn("username");
		when(mockStorage.get("username")).thenReturn(mockUser);
		restoreUser.execute(mockRequest);
		verify(mockUser).setEnable(true);

	}

}
