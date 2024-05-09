package example.com.repository;

import lombok.SneakyThrows;
import org.postgresql.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionDB {
    private static String DB_USERNAME;
    private static String DB_PASSWORD;
    private static String DB_URI;

    static {
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream("C:\\Users\\aruzhan one love\\Desktop\\zhava\\maven-archetype-test\\HttpServletsDMDEV\\database\\src\\main\\resources\\application.properties")) {
            Class.forName("org.postgresql.Driver");
            prop.load(fis);
            DB_USERNAME = prop.getProperty("db.user");
            DB_PASSWORD = prop.getProperty("db.password");
            DB_URI = prop.getProperty("db.uri");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    public static Connection getConnection() {
        return DriverManager.getConnection(DB_URI, DB_USERNAME, DB_PASSWORD);
    }
}
