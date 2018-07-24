package com.fdm.io;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.fdm.io.Serializer;
import com.fdm.model.User;

public class SerializerTest {

	@Spy
	Serializer serilz;
	@Mock
	Map<String, User> mockMap;
	@Mock
	User mockUser;
	@Mock
	ObjectOutput mockOutput;
	@Mock
	ObjectInput mockInput;

	@Before
	public void setUp() {
		serilz = new Serializer();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testWhenIOExceptionOccursOnWriteObjectMethodFlushIsNotCalledButCloseIs()
			throws IOException {
		doReturn(mockOutput).when(serilz).getObjectOutput("");
		doThrow(new IOException()).when(mockOutput).writeObject(mockMap);
		serilz.serializeMap(mockMap, "");
		verify(mockOutput, times(0)).flush();
		verify(mockOutput).close();
	}

	@Test
	public void testSerializeMapMethodCallsWriteObjectFlishandCloseMethodsOnSerializedObject()
			throws FileNotFoundException, IOException {
		doReturn(mockInput).when(serilz).getObjectInput("mockMap");
		serilz.serializeMap(mockMap, "path");
		verify(mockOutput).writeObject(mockMap);
		verify(mockOutput).flush();
		verify(mockOutput).close();
	}

	@Test
	public void testSerializeMethodHandlesAFileNotFoundExceptionNoInteractionOccurWithObjectOutput()
			throws FileNotFoundException, IOException {
		doThrow(new FileNotFoundException()).when(serilz).getObjectOutput("");
		serilz.serializeMap(mockMap, "");
		verifyZeroInteractions(mockOutput);
	}

	@Test
	public void testWhenCloseThrowsIOException() throws IOException {
		doReturn(mockOutput).when(serilz).getObjectOutput("");
		doThrow(new IOException()).when(mockOutput).close();
		serilz.serializeMap(mockMap, "");
		verify(mockOutput).writeObject(mockMap);
		verify(mockOutput).flush();

	}

	@Test
	public void testGetObjectOutputReturnsAnInstanceOfObjectOutputStream()
			throws IOException {
		ObjectOutput oo = serilz.getObjectOutput("test.ser");
		assertTrue(oo instanceof ObjectOutputStream);
		serilz.closeOutput(oo);

	}

	@Test
	public void testDeserializeMethodCallsReadObjectAndCloseOnTheSerializeObject()
			throws FileNotFoundException, IOException, ClassNotFoundException {
		doReturn(mockInput).when(serilz).getObjectInput("");
		serilz.deserialize("");
		verify(mockInput).readObject();
		verify(mockInput).close();
	}

	@Test
	public void testDeserializeMethodHandlesAFileNotFoundExceptionNoInteractionOccursWithObjectInput()
			throws FileNotFoundException, IOException {
		doThrow(new FileNotFoundException()).when(serilz).getObjectInput("");
		serilz.deserialize("");
		verifyZeroInteractions(mockInput);
	}

}
