package com.fdm.actions;

import org.apache.log4j.Logger;
import com.fdm.model.User;
import com.fdm.model.storage.Storage;

/**
 * Login class used to log a user of the system into storage
 * 
 * @author julia.kovale
 *
 */
public class Login {

	private Storage storage;
	static Logger log = Logger.getLogger(Login.class);

	/**
	 * 
	 * @param user  and storage
	 * @return 
	 */
	public User loginUser(String username) {
		return storage.get(username);
		
		
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}
}
