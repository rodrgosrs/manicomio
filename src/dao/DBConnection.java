package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * @author Rodrigo
 */

public class DBConnection {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/sgm";
    private static final String USER = "root";
    private static final String PASSWORD = "root2005";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.println("ERRO FATAL: Driver JDBC não encontrado!");
            ex.printStackTrace();
            System.exit(1);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
