package org.example.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connect {
    static Connection conn;
    public static Connection createConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String DB_URL = "jdbc:mysql://localhost:3306/project";
            String USER1 = "root";
            String PASS = "password";

           conn = DriverManager.getConnection(DB_URL,USER1,PASS);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (Connection) conn;
    }

}
