package com.fdm.appenders;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import com.fdm.actions.BanUser;
import com.fdm.actions.setRole;

public class SysAdminappenderTest {

	SysAdminAppender sysAdAppend;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		sysAdAppend = new SysAdminAppender();
	}

	@Test
	public void testAppendMethodReturnssetRoleWhenOptionZeroIsPassedIn() {
		assertTrue(sysAdAppend.append(0) instanceof setRole);
	}

	@Test
	public void testAppendMethodBanUserWhenOptionOneIsPassedIn() {
		assertTrue(sysAdAppend.append(1) instanceof BanUser);
	}

}
