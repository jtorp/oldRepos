package com.fdm.command;

import com.fdm.actions.Request;
import com.fdm.model.storage.Storage;

public interface ICommand {

	void execute(Request request);

	void setStorage(Storage storage);

}
