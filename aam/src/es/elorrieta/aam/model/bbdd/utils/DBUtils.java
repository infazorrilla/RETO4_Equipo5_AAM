package es.elorrieta.aam.model.bbdd.utils;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private String hostname;
	private String port;
	private String username;
	private String password;
	private String database;

	public java.sql.Connection connection;

	public DBUtils() {
		this.hostname = "localhost";
		this.port = "3306";
		this.username = "root";
		this.password = "";
		this.database = "aam";
	}

	public void connect() {
		String url = "jdbc:mysql://" + this.hostname + ":" + this.port + "/" + this.database;
		try {
			this.connection = DriverManager.getConnection(url, this.username, this.password);
		} catch (SQLException ex) {
			this.connection = null;
		}
	}

	public void disconnect() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			this.connection = null;
		}
		this.connection = null;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public java.sql.Connection getConnection() {
		return connection;
	}

	public void setConnection(java.sql.Connection connection) {
		this.connection = connection;
	}

	public boolean isConnected() {
		try {
			return this.connection != null && !this.connection.isClosed();
		} catch (SQLException e) {
			return false;
		}
	}

}
