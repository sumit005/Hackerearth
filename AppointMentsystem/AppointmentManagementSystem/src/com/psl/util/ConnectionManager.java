package com.psl.util;

import java.sql.Connection;

public interface ConnectionManager {

	Connection getConnection();
	void closeConnection();
}
