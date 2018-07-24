package com.fdm.io;

import java.io.*;

import com.fdm.controller.LoginController;
import com.fdm.model.User;
import com.fdm.model.storage.MapuserStorageSingleton;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

/***
 * Read and Write map current state into stream of bytes, saving the sate of map
 * storage
 * 
 * @param location of the file is set in path
 *
 */
public class Serializer {

	public final static Logger logger = Logger.getLogger(LoginController.class);

	public void serializeMap(Map<String, User> map, String path) {

		ObjectOutput output = null;

		try {
			output = getObjectOutput(path);
			output.writeObject(map);
			output.flush();
		} catch (FileNotFoundException e) {
			logger.error("serializer error - no file found!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (output != null)
				closeOutput(output);
		}
	}

	public void closeOutput(ObjectOutput output) {
		try {
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Map<String, User> deserialize(String path) { 
		ObjectInput input = null;
		Map<String, User> map = null;

		try {
			input = getObjectInput(path);
			map = (Map<String, User>) input.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (input != null)
				closeInput(input);
		}
		return map;
	}

	public void closeInput(ObjectInput input) {
		try {
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ObjectOutput getObjectOutput(String path) throws FileNotFoundException, IOException {
		return new ObjectOutputStream(new FileOutputStream(path));
	}

	public ObjectInput getObjectInput(String path) throws FileNotFoundException, IOException {
		return new ObjectInputStream(new FileInputStream(path));
	}
}
