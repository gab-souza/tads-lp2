package br.edu.ifsp.biblioteca.domain;

public class Usuario {
    private Long id;
    private String nome, email;

    public Usuario(Long id, String nome, String email){
        this.id = id;
        this.nome= nome;
        this.email = email;
    }

    public Long getId(){
        return this.id;
    }

    public void setId(){
        this.id = id;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(){
        this.nome = nome;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(){
        this.email= email;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
