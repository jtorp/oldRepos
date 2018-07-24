package com.fdm.validators;

import com.fdm.Exceptions.RegistrationException;
import com.fdm.model.User;
import com.fdm.model.storage.Storage;

public class RegistrationValidator {

	@SuppressWarnings("unused")
	private User user;
	private Storage storage;

	public void validate(User user) throws RegistrationException {
		String username = user.getUsername();

		if (storage.get(username) != null) // already exists i.e. not null//
			throw new RegistrationException("Username alreay exsits");
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

}
