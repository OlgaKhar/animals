import animal.AnimalDAO;
import connection.DBConnection;
import menu.AnimalRegistryMenu;

import java.sql.Connection;


public class Main {
    public static void main(String[] args) {
        DBConnection dbConn = new DBConnection();
        Connection conn = dbConn.connect();
        AnimalDAO dao = new AnimalDAO(conn);

        AnimalRegistryMenu menu = new AnimalRegistryMenu(dao);
        menu.run();
    }
}