package com.fdm.model.storage;

import com.fdm.model.User;


public interface Storage {
	
	public void add(User user);
	
	public User get(String user);
	
	public void remove(String user);
	

}
