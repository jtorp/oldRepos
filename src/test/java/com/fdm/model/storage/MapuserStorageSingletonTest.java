package com.fdm.model.storage;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.*;

import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fdm.io.Serializer;
import com.fdm.model.User;




public class MapuserStorageSingletonTest {
	
	private MapuserStorageSingleton mus;
	
	@Mock
	Map<String, User> mockmap;
	@Mock
	User mockUser;
	@Mock
	Serializer mockserializer;
	
	
	@Before

	public void setUp(){
		mus = MapuserStorageSingleton.getInstance();
		MockitoAnnotations.initMocks(this);
		mus.setMap(mockmap);
		mus.setSerializer(mockserializer);

	}
	
	@Test
	public void testGetInstanceReturnsANotNullObjectWhenTheGetInstanceMethodIsCalled() {
		assertNotNull(MapuserStorageSingleton.getInstance());
	}
	
	@Test
	public void testGetInstanceReturnstheSameInstancWhenItIsCAlledTwice(){
		assertEquals(mus,MapuserStorageSingleton.getInstance());
	}
	
	@Test
	public void testAddMethodCallsThePutMethodFromMap(){
		when(mockUser.getUsername()).thenReturn("myusername");
		mus.add(mockUser);
		verify(mockmap).put(mockUser.getUsername(),mockUser);
	}

	@Test
	public void testGetMethodCallsGetMapMethod(){
		mus.get("myusername");
		verify(mockmap).get("myusername");
	}
	
	@Test
	public void testremoveMethodCallsRemoveMapMethod(){
		mus.remove("myusername");
		verify(mockmap).remove("myusername");
		
	}

}
