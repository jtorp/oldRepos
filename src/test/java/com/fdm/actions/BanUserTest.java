package com.fdm.actions;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fdm.model.User;
import com.fdm.model.storage.Storage;

public class BanUserTest {
	
	BanUser banUser;
	
	
	@Mock
	User mockUser;
	@Mock
	Storage mockStorage;
	@Mock
	Request mockRequest;

	@Before
	public void setUp() {
		banUser = new BanUser();
		MockitoAnnotations.initMocks(this);
		banUser.setStorage(mockStorage);
	}
	

	@Test
	public void testThatexecuteMethodCallsSetEnable() {
		when(mockRequest.getUser()).thenReturn(mockUser);
		when(mockUser.getUsername()).thenReturn("username");
		when(mockStorage.get("username")).thenReturn(mockUser);
		
		banUser.execute(mockRequest);
		verify(mockUser).setEnable(false);
	}


	}


