package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import com.google.gson.Gson;
import beans.Users;
import connection.DBConnection;

public class UsuarioController implements IUsuarioController {
    @Override 
    public String login(String username, String contrasena) {
        Gson gson = new Gson();
        DBConnection conn = new DBConnection();
        String sql = "SELECT * FROM users WHERE username = '" + username + "' AND contrasena = '" + contrasena + "'";
        
        try {
            Statement st = conn.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String email = rs.getString("email");
                double saldo = rs.getDouble("saldo");
                boolean premium = rs.getBoolean("premium");
                
                Users usuario = new Users(username, contrasena, nombre, apellidos, email, saldo, premium);
                return gson.toJson(usuario);                
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            conn.desconectar();
        }
        
        return "false";
    }

    @Override
    public String register(String username, String contrasena, String nombre, String apellidos, String email, double saldo, boolean premium) {
        Gson gson = new Gson();

        DBConnection conn = new DBConnection();
        String sql = "INSERT INTO users VALUES('" + username + "', '" + contrasena + "', '" + nombre
                    + "', '" + apellidos + "', '" + email + "', " + saldo + ", " + premium + ")";
        
        try {
            Statement st = conn.getConnection().createStatement();
            st.executeUpdate(sql);
            Users usuario = new Users(username, contrasena, nombre, apellidos, email, saldo, premium);
            st.close();

            return gson.toJson(usuario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conn.desconectar();
        }
        return "false";
    }
    
}
