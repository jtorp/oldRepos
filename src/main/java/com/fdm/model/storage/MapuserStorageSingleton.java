package com.fdm.model.storage;

import java.util.Map;
import com.fdm.io.Serializer;
import com.fdm.model.User;

public class MapuserStorageSingleton implements MapUserStorage {

	private static MapuserStorageSingleton instance;
	private Map<String, User> map;
	private Serializer serializer;
	private static final String PATH = "userStorage";

	private MapuserStorageSingleton() {

	};

	public static MapuserStorageSingleton getInstance() {
		if (instance == null)
			instance = new MapuserStorageSingleton();
		return instance;
	}

	// set storage to be used
	public void setMap(Map<String, User> map) {
		this.map = map;
	}


	// adding user to the storage
	public void add(User user) {
		map.put(user.getUsername(), user);
		serializeStorage();

	}

	// returning user
	public User get(String username) {
		deserializeMap();
		return map.get(username);
	}

	public void remove(String username) {
		map.remove(username);
		serializeStorage();
	}
	
	public void setSerializer(Serializer serializer) {
		this.serializer = serializer;
	}

	public void serializeStorage() {
		serializer.serializeMap(map, PATH);
	}

	public Map<String, User> deserializeMap() {
		
		if(serializer.deserialize(PATH) == null)
			return map;
		else
			return (map = serializer.deserialize(PATH));
	}

}
