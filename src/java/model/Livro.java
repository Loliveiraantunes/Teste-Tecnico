package model;

public class Livro {
    
    private String titulo;
    private String autor;
    private String edicao;

    public Livro() {
    }

    public Livro(String titulo, String autor, String edicao) {
        this.titulo = titulo;
        this.autor = autor;
        this.edicao = edicao;
    }

    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }
    
    
    
    
}
