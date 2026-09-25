package br.edu.ifsp.biblioteca.domain;

import java.util.ArrayList;
import java.util.List;

public class Livro {
    private Long id;
    private String isbn, titulo;
    private int anoPublicacao;
    private List<Exemplar> listaExemplares;
    private List<Autor> autores;

    public Livro(String isbn, String titulo, int anoPublicacao){
        this.isbn = isbn;
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.listaExemplares = new ArrayList<>();
        this.autores= new ArrayList<>();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoPublicacao() {
        return this.anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public void adicionarExemplar(Exemplar ex){
        this.listaExemplares.add(ex);
    }

    public void addAutor(Autor autor){
        this.autores.add(autor);
    }

    public List<Autor> getAutores(){
        return this.autores;
    }

    public List<Exemplar> getListaExemplares(){
        return this.listaExemplares;
    }


    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", anoPublicacao=" + anoPublicacao +
                '}';
    }
}
