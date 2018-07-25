package com.fdm.controller;

import com.fdm.actions.Request;
import com.fdm.appenders.SysAdminAppender;
import com.fdm.command.ICommand;
import com.fdm.view.SysAdminView;

public class SysAdminController implements MainController {

	private SysAdminView adminView;
	private Request request;
	private ICommand command;
	private SysAdminAppender sysadminappender;

	public void setView(SysAdminView adminView) {
		this.adminView = adminView;

	}

	public void setICommand(ICommand command) {
		this.command = command;
	}

	public void setSysAdminAppender(SysAdminAppender sysadminappender) {
		this.sysadminappender = sysadminappender;
	}

	public void handle() {
		request = adminView.getInput();
		int option = request.get();
		ICommand cmd = sysadminappender.append(option);
		cmd.execute(request);

	}

}


