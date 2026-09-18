package br.edu.ifsp.biblioteca.repository;

import br.edu.ifsp.biblioteca.domain.Livro;
import org.springframework.boot.autoconfigure.web.ConditionalOnEnabledResourceChain;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
@Profile("jdbc")
public class LivroRepositoryJdbc implements ILivroRepository{

    private final DataSource dataSource;
    public LivroRepositoryJdbc(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public Livro salvar(Livro novo) {
       try(Connection conexao = this.dataSource.getConnection()){
        conexao.setAutoCommit(false);

        if(novo.getId() == null){
            this.inserirLivro(conexao, novo);
        } else {
            this.atualizarLivro(conexao, novo);
        }
        this.salvarAutores(conexao, novo);
        this.salvarExemplares(conexao, novo);
       } catch (SQLException erro) {
       }
        return novo;
    }
    private void inserirLivro(Connection conexao, Livro livro){
        String sql = "INSERT INTO livro (isbn, titulo, ano_publicacao) VALUES (?, ?, ?)";
    }

    private void atualizarLivro(Connection conexao, Livro livro){

    }

    private void salvarAutores(Connection conexao, Livro livro){

    }

    private void salvarExemplares(Connection conexao, Livro livro){}

    @Override
    public List<Livro> listarTodos() {
        return List.of();
    }

    @Override
    public Optional<Livro> buscarPorId(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Livro> buscarPorIsbn(String isbn) {
        return Optional.empty();
    }

    @Override
    public List<Livro> buscarPorTitulo(String titulo) {
        return List.of();
    }
}
