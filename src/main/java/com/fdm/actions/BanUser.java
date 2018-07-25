package com.fdm.actions;

import org.apache.log4j.Logger;
/**
 * Class provides system adiministrator with control over users access */

import com.fdm.command.ICommand;
import com.fdm.model.User;
import com.fdm.model.storage.Storage;

public class BanUser implements ICommand {
	public final static Logger logger = Logger.getLogger(BanUser.class);

	Storage storage;
	User user;

	public void setStorage(Storage storage) {
		this.storage = storage;

	}

	/**
	 * Method for SysAdmin to Ban User
	 * 
	 * @param request with details of the user request
	 */

	public void execute(Request request) {
		User user = request.getUser();
		String username = user.getUsername();
		User bannedUser = storage.get(username);
		bannedUser.setEnable(false);
		storage.remove(username);
		storage.add(bannedUser);
		logger.info("This user is banned");

	}

}
