package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    //данные для соединения
    private static final String db_url = "jdbc:postgresql://localhost:5432/postgres";

    private static final String db_name = "postgres";

    private static final String db_password = "2512";

    static {
        try {
            // Подключение драйвера для postgresql
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // получения соединения с базой данных
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(db_url, db_name, db_password);
    }
}




