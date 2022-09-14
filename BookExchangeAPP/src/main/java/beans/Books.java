package beans;

public class Books {
    private int id;
    private String titulo;
    private String genero;
    private String autor;
    private String ano;
    private int copias;

    public Books(int id, String titulo, String genero, String autor, String ano, int copias) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.autor = autor;
        this.ano = ano;
        this.copias = copias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public int getCopias() {
        return copias;
    }

    public void setCopias(int copias) {
        this.copias = copias;
    }

    @Override
    public String toString() {
        return "Books{" + "id=" + id + ", titulo=" + titulo + ", genero=" + genero + ", autor=" + autor + ", ano=" + ano + ", copias=" + copias + '}';
    }
       
}
