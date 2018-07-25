package com.fdm.actions;

import org.apache.log4j.Logger;

import com.fdm.command.ICommand;
import com.fdm.model.storage.Storage;

public class RemoveUser implements ICommand {
	public final static Logger logger = Logger.getLogger(RemoveUser.class);
	private Storage storage;
	
/** Method to Remove User
 * @param request with user details
 * 
 * */
	public void execute(Request request) {
		storage.remove(request.getUser().getUsername());
		
		System.out.println("User removed!");
		logger.info("This user is removed");

	}

	public void setStorage(Storage storage) {
		this.storage = storage;

	}

}
