package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private final String url = "jdbc:mysql://localhost:3306/mydb";
    private final String user = "olga_ubuntu";
    private final String password = "1234";

    public Connection connect() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Загрузка драйвера MySQL
            conn = DriverManager.getConnection(url, user, password); // Установление соединения
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage()); // Обработка ошибок
        }
        return conn;
    }
}