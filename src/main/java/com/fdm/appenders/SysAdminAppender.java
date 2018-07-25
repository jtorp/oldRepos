package com.fdm.appenders;

import com.fdm.actions.BanUser;
import com.fdm.actions.RemoveUser;
import com.fdm.actions.RestoreBannedUser;
import com.fdm.actions.setRole;
import com.fdm.command.ICommand;
import com.fdm.model.storage.Storage;

/**
 * SysAdminAppender implements Appender interface
 */
public class SysAdminAppender implements IAppender {

	private Storage storage;
	private ICommand command;

	/**
	 * @param option
	 *            choice that system administrator can perform
	 * @return the action to be performed
	 */
	public ICommand append(int option) {

		if (option == 0)
			command = new setRole();
		if (option == 1)
			command = new BanUser();
		if (option == 2)
			command = new RestoreBannedUser();
		if (option == 3)
			command = new RemoveUser();
		command.setStorage(storage);
		return command;

	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	
}