package com.fdm.model.DBstorage;

import com.fdm.connections.ConnectionPool;
import com.fdm.model.storage.Storage;

public interface DBStorage {

	public void setConnectionPool(ConnectionPool connpool);
}
