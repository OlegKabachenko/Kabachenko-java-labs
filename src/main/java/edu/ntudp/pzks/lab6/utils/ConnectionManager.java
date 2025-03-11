package edu.ntudp.pzks.lab6.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    PropertiesUtil propertiesUtil = new PropertiesUtil();

    private final String URL = propertiesUtil.get("db.url");
    private final String USER = propertiesUtil.get("db.user");
    private final String PASSWORD = propertiesUtil.get("db.password");

    public Connection open() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
