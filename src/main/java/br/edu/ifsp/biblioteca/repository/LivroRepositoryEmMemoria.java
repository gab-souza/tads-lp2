package br.edu.ifsp.biblioteca.repository;

import br.edu.ifsp.biblioteca.domain.Livro;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.*;

public class LivroRepositoryEmMemoria implements ILivroRepository {

    private final Map<Long, Livro> livros = new HashMap<>();
    private Long sequenciaId = 0L;

    @Override
    public Livro salvar(Livro livro) {

        if (livro.getId() == null) {
            this.sequenciaId++;
            livro.setId(this.sequenciaId);
        }
        this.livros.put(livro.getId(), livro);List<Livro> colecaoLivros = new ArrayList<>(this.livros.values());
        return livro;
    }

    @Override
    public List<Livro> listarTodos() {
        List<Livro> colecaoLivros = new ArrayList<>(this.livros.values());
        return colecaoLivros;
    }

    @Override
    public Optional<Livro> buscarPorId(Long id) {
        Livro l = this.livros.get(id);
        if (l == null) {
            return Optional.empty();
        }
        return Optional.of(l);
    }

    @Override
    public Optional<Livro> buscarPorIsbn(String isbn) {
        List<Livro> colecaoLivros = new ArrayList<>(this.livros.values());

        for (int i = 0; i < colecaoLivros.size(); i++) {
            Livro livro = colecaoLivros.get(i);
            String livroIsbn = livro.getIsbn();

            if (livroIsbn.equalsIgnoreCase(isbn)) {
                return Optional.of(livro);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Livro> buscarPorTitulo(String titulo) {
        List<Livro> colecaoTitulo = new ArrayList<>(this.livros.values());
        List<Livro> encontBusca = new ArrayList<>();

        for (int i = 0; i < colecaoTitulo.size(); i++) {
            Livro livroBusca = colecaoTitulo.get(i);

            if (livroBusca.getTitulo().contains(titulo.toLowerCase())) {
                encontBusca.add(livroBusca);
            }
        }
        return encontBusca;
    }
}

