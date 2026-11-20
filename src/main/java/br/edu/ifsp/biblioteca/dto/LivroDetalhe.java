package br.edu.ifsp.biblioteca.dto;

import br.edu.ifsp.biblioteca.domain.Autor;
import br.edu.ifsp.biblioteca.domain.Livro;

import java.util.List;

import static java.util.stream.Collectors.toList;

public record LivroDetalhe(Long id, String isbn, String titulo, int anoPublicacao, List<String> autores, long exemplaresDisponiveis, int qtdExemplares) {
    public static LivroDetalhe of(Livro livro){
        return new LivroDetalhe(
                livro.getId(),
        livro.getIsbn(),
        livro.getTitulo(),
        livro.getAnoPublicacao(),
        livro.getAutores().stream().map(Autor::getNome).toList(),
        livro.quantidadeDisponivel(),
        livro.getExemplares().size());
    }

}
