package com.fdm.connections;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.junit.Before;
import org.junit.Test;


public class ConnectionPoolTest {
	
	@Mock
	Connection mockConn;
	@Spy
	ConnectionPool spyconnpool;
	
   @Before
   public void setUp(){
	   MockitoAnnotations.initMocks(this);
		spyconnpool = ConnectionPool.getInstance("", "", "");
	}
   
	@Test
	public void testCheckoutMethodIsCalled() throws SQLException{
		Connection mockConn = spyconnpool.checkout();
		assertTrue(mockConn instanceof Connection);
	}

}
