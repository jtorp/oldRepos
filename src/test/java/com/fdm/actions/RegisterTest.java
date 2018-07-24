package com.fdm.actions;
import org.junit.Test;
import org.junit.*;
import static org.mockito.Mockito.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.fdm.model.User;
import com.fdm.model.storage.*;



public class RegisterTest {
	Register register;
	
	
	@Mock
	Storage mockStorage;
	@Mock
	User mockUser;
	

	@Before
	public void setUp() {
		register = new Register();
		MockitoAnnotations.initMocks(this);
		register.setStorage(mockStorage);
	}
	
	
	@Test
	public void testThatRegisterUserMethodCallsAddUserToStorageMethod(){
		register.registerUser(mockUser);
		verify(mockStorage).add(mockUser);
		
	}

}
