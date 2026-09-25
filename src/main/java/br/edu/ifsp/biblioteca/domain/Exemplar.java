package br.edu.ifsp.biblioteca.domain;

public class Exemplar {
    private Long id;
    private String cod;
    private Livro livro;
    private EStatusExemplar status;

    public Exemplar(String cod, Livro livro){
        this.cod = cod;
        this.livro = livro;
        this.status = EStatusExemplar.DISPONIVEL;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public EStatusExemplar getStatus() {
        return status;
    }

    public void setStatus(EStatusExemplar status) {
        this.status = status;
    }

    public void emprestar(){
        if(this.status == EStatusExemplar.EMPRESTADO){
            throw new IllegalStateException("Exemplar " + this.cod + " já está emprestado");
        }
        this.status = EStatusExemplar.EMPRESTADO;
    }

    public void devolver(){
        this.status = EStatusExemplar.DISPONIVEL;
    }

    public boolean estaDisponivel(){
        return this.status == EStatusExemplar.DISPONIVEL;
    }

    @Override
    public String toString() {
        return "Exemplar{" +
                "id=" + id +
                ", cod='" + cod + '\'' +
                ", livro=" + livro +
                ", status=" + status +
                '}';
    }
}
