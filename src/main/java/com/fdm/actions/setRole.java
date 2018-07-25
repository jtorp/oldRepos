package com.fdm.actions;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.fdm.command.ICommand;
import com.fdm.model.storage.Storage;

public class setRole implements ICommand {
	private static Logger logger = Logger.getLogger(setRole.class);
    
	
	private Scanner scanner;
	private Storage storage;

	public void execute(Request request) {
		System.out.println("Role ID : ");
		scanner = new Scanner(System.in);
		int role = ((scanner.nextInt()));
		request.getUser().setRole(role);
		logger.info("User Role ID has been re-set");

		
		// TODO Auto-generated method stub
		
	}

	public void setStorage(Storage storage) {
		// TODO Auto-generated method stub
		
	}
	



}
