package com.fdm.model.DBstorage;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import com.fdm.connections.ConnectionPool;
import com.fdm.model.User;
import com.fdm.model.storage.Storage;

public class DBUserStorage implements DBStorage, JDBCStorage {

	private ConnectionPool connpool = ConnectionPool.getInstance(null, null, null);
	private Connection con;
	private CallableStatement callstmt;

	public void add(User user) {

		try {
			String query = "{call ADD_USERS(?,?,?,?,?)}";
			con = connpool.checkout();
			CallableStatement stmt = con.prepareCall(query);

			callstmt.setString(1, user.getUsername());
			callstmt.setString(2, user.getPassword());
			callstmt.setString(3, user.getFirstname());
			callstmt.setString(4, user.getLastname());
			callstmt.setLong(5, user.getRole());
			// update
			callstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}

		// close in reverse order

	}

	public User get(String user)

	{ // to hide
	}

	private void closeAll() {

		try {
			if (callstmt != null)
				callstmt.close();
			if (con != null)
				conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void remove(String user) {

	}

	public void setConnectionPool(ConnectionPool connpool) {
		this.connpool = connpool;

	}

}
