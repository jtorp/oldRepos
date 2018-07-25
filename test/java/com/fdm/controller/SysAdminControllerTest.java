package com.fdm.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.fdm.command.SysAdminCommand;
import com.fdm.model.User;
import com.fdm.view.SysAdminView;

public class SysAdminControllerTest {

	SysAdminController sysadminController;

	@Mock
	User mockUser;
	@Mock
	SysAdminView mockAdminView;
	@Mock
	SysAdminCommand mockCommand;

	@Before
	public void setUp() {
		sysadminController = new SysAdminController();
		MockitoAnnotations.initMocks(this);
		sysadminController.setView(mockAdminView);
		sysadminController.setSysAdminCommand(mockCommand);
	}

	@Test
	public void testHandleMethodCallsGetInputMethodFromSysAdminView() {
		when(mockCommand.command(anyInt())).thenReturn(mockCommand);
		sysadminController.handle();
		verify(mockAdminView).getInput();
	}

	@Test
	public void testHandleMethodInvokescomandMethod() {
		when(mockCommand.command(anyInt())).thenReturn(mockCommand);
		sysadminController.handle();
		verify(mockCommand).command(anyInt());
	}

}
