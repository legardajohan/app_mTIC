package test;
import beans.Books;
import connection.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;

public class OperacionesDB {
    public static void main(String[] args) {
        listarLibros(); 
        //actualizarLibro(118, "Novela infantil");
    }
    
    public static void actualizarLibro(int id, String genero) {
        DBConnection conn = new DBConnection();
        String sql = "UPDATE books SET genero = '" + genero + "'WHERE id = " + id;
        
        try {
            Statement st = conn.getConnection().createStatement();
            st.executeUpdate(sql);
            
        } catch(Exception e){
            System.out.println(e.getMessage());
        } 
        finally {
            conn.desconectar();
        }
    }
    
    public static void listarLibros() {
        DBConnection conn = new DBConnection();
        String sql = "SELECT * FROM books";
        try {
            Statement st = conn.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {                
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String genero = rs.getString("genero");
                String autor = rs.getString("autor");
                String ano = rs.getString("ano"); 
                int copias = rs.getInt("copias");
                
                Books book = new Books(id, titulo, genero, autor, ano, copias);
                System.out.println(book.toString());
            }
            st.executeQuery(sql);
            
        } catch(Exception e){
            System.out.println(e.getMessage());
        } 
        finally {
            conn.desconectar();
        }
        
    }
}
