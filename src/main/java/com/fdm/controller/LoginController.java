package com.fdm.controller;

import org.apache.log4j.Logger;

import com.fdm.Exceptions.LoginException;
import com.fdm.actions.Login;
import com.fdm.model.User;
import com.fdm.validators.LoginValidator;
import com.fdm.view.View;

public class LoginController implements MainController {

	private View view;
	private Login log;
	private LoginValidator logvalidator;

	public final static Logger logger = Logger.getLogger(LoginController.class);

	public void setView(View view) {
		this.view = view;

	}

	public void setLogin(Login log) {
		this.log = log;

	}

	public void setLoginValidator(LoginValidator logval) {
		logger.debug("Set Validator" + logval.getClass());
		this.logvalidator = logval;

	}

	public void handle() {
		User user = view.getInput();
		try {
			logvalidator.validate(user);
			log.loginUser("");
		} catch (LoginException e) {
			logger.error("Login error message" + e.getStackTrace());

		}

	}
}
