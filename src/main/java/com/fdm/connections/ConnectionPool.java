package com.fdm.connections;

import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class ConnectionPool {

	private static int m_InitialConnectionCount = 1;
	private static List<Connection> m_AvailableConnections = Collections.synchronizedList(new ArrayList<Connection>());
	private static List<Connection> m_UsedConnections = Collections.synchronizedList(new ArrayList<Connection>());
	private static String m_URLString = null;
	private static String m_UserName = null;
	private static String m_Password = null;

	private static ConnectionPool instance;

	public static ConnectionPool getInstance(String urlString, String user, String password) {
		if (instance == null) {
			try {
				instance = new ConnectionPool();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}

	private ConnectionPool() throws SQLException {

	}

	public Connection checkout() {

		return null;
	}
}
