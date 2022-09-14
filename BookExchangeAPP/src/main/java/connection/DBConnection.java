package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    Connection connection;
    static String db = "book_change";
    static String port = "3306";
    static String login = "root";
    static String password = "ADMIN";
    
    public DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:" + this.port + "/" + this.db;
            connection = DriverManager.getConnection(url, this.login, this.password);
            System.out.println("¡Conexión establecida!");            
        } catch (Exception e) {
            System.out.println("Error de conexión");
        }
    }
    
    public Connection getConnection() {
        return connection;
    }
    
    public void desconectar() {
        connection = null;
    }
    
}
