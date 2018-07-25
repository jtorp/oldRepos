package com.fdm.controller;

import com.fdm.Exceptions.RegistrationException;
import com.fdm.actions.Register;
import com.fdm.model.User;
import com.fdm.validators.RegistrationValidator;
import com.fdm.view.RegistrationView;

public class RegistrationController implements MainController {
	// global//
	private RegistrationView view;
	private Register register;
	private RegistrationValidator validator;

	public void setView(RegistrationView view) {
		this.view = view;
	}

	public void setVal(RegistrationValidator validator) {
		this.validator = validator;
	}

	public void setReg(Register register) {
		this.register = register;
	}

	public void handle() {
		User user = view.getInput();
		try {

			validator.validate(user);
			register.registerUser(user);

		} catch (RegistrationException e) {
			e.printStackTrace();

		}

	}

}
