package com.fdm.actions;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fdm.model.User;
import com.fdm.model.storage.Storage;

public class RemoveUserTest {

	RemoveUser removeUser;

	@Mock
	Storage mockStorage;
	@Mock
	User mockUser;
	@Mock
	Request mockrequest;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		removeUser= new RemoveUser();
		removeUser.setStorage(mockStorage);

	}

	@Test
	public void testRemoveUserMethodsCallsStorageRemoveMethod() {
		
		when(mockrequest.getUser()).thenReturn(mockUser);
		when(mockUser.getUsername()).thenReturn("username");
		removeUser.execute(mockrequest);
		verify(mockStorage).remove("username");
		
	}
	

}
