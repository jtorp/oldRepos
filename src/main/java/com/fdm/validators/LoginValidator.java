package com.fdm.validators;

import org.apache.log4j.Logger;
import com.fdm.Exceptions.LoginException;
import com.fdm.model.User;
import com.fdm.model.storage.Storage;

public class LoginValidator {

	public final static Logger logger = Logger.getLogger(LoginValidator.class);

	private User user;
	private User storedUser;
	private Storage storage;

	public void validate(User user) throws LoginException {
		String username = user.getUsername();
		storedUser = storage.get(username);

		if (storedUser == null) {
			logger.error("invalid username");
			throw new LoginException("No such user");
		}

		else if (!storedUser.getPassword().equals(user.getPassword()))
			throw new LoginException("Wrong password");

	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}
}
