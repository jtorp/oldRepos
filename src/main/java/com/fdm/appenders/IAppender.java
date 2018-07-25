package com.fdm.appenders;

import com.fdm.command.ICommand;



public interface IAppender {
	/**
	 * @param option
	 *            - option to be performed e.g. ban user
	 * @return action to be performed e.g. user will be banned
	 */



	public ICommand append(int option);
}
