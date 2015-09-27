package com.barrypress.wiz.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class WizDB {

    private Connection conn;

    public WizDB() {
        try {
            conn = DriverManager.getConnection("jdbc:derby:wizDB");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() { return conn; }

}
