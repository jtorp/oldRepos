package com.fdm.actions;

import org.apache.log4j.Logger;

import com.fdm.command.ICommand;
import com.fdm.model.User;
import com.fdm.model.storage.Storage;

public class RestoreBannedUser implements ICommand {

	private static Logger logger = Logger.getLogger(RestoreBannedUser.class);
	private Storage storage;

	public void setStorage(Storage storage) {
		this.storage = storage;

	}

	public void execute(Request request) {
		User user = request.getUser();
		String username = user.getUsername();
		User restoredUser = storage.get(username);
		restoredUser.setEnable(true);
		storage.remove(username);
		storage.add(restoredUser);

		logger.info("Welcome Again! Your username is restored/unbanned!");
		;

	}

}
