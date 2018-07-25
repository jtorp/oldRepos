package com.fdm.actions;

import com.fdm.model.User;
import com.fdm.model.storage.Storage;

/**
 * Register class used to enable new user registration
 * 
 * @author julia.kovale
 * @param storage
 * 
 * 
 *                /
 */

public class Register {
	private Storage storage;

	public void registerUser(User user) {
		storage.add(user);

	}

	public void setStorage(Storage storage) {
		this.storage = storage;

	}

}
