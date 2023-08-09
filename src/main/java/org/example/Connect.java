package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connect {
    public Connection connect(String propFile) throws IOException, ClassNotFoundException, SQLException {
        Properties prop = new Properties();
        InputStream reader = new FileInputStream("C:\\Users\\john.thomas2\\IdeaProjects\\HelloWorld\\src\\"+propFile);
        prop.load(reader);
        String dbURL = prop.getProperty("URL");
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(dbURL, username, password);
        if (con != null) {
            System.out.println("Connection OK");
        } else {
            System.out.println("Connection Failed");
        }
        return con;
    }
}
