package com.fdm.actions;

import com.fdm.model.User;

public class Request {

	private User user;
	private int option;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setRequest(int option) {
		this.option = option;
	}

	public int get() {
		return option;
	}

}
