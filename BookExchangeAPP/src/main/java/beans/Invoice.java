package beans;

public class Invoice {
    private int id;
    private String fecha;
    private int username;

    public Invoice(int id, String fecha, int username) {
        this.id = id;
        this.fecha = fecha;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getUsername() {
        return username;
    }

    public void setUsername(int username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Invoice{" + "id=" + id + ", fecha=" + fecha + ", username=" + username + '}';
    }
    
}
