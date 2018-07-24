package com.fdm.model.storage;

import java.util.*;

import com.fdm.model.User;



public interface MapStorage {
	
	public abstract void setMap(Map <String, User> map);
	
	public abstract void serializeStorage();
    public abstract Map<String, User> deserializeMap();

}
