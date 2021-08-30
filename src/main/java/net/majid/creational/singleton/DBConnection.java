package net.majid.creational.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author majid.shoorabi
 * @created 2021-29-August
 * @project PeySaz
 */

public class DBConnection {

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:mem:dbname;";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";


    private static DBConnection dbConnection;
    private Connection connection;

    private DBConnection() {
        initialConnection();
    }

    public static DBConnection getInstance() {
        if (dbConnection == null)
            synchronized (DBConnection.class) {
                if (dbConnection == null)
                    dbConnection = new DBConnection();
            }
        return dbConnection;
    }

    public Connection getConnection() {
        return connection;
    }

    private void initialConnection() {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection= DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
