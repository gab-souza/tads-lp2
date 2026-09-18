package br.edu.ifsp.biblioteca.service;

import br.edu.ifsp.biblioteca.domain.Autor;
import br.edu.ifsp.biblioteca.domain.Exemplar;
import br.edu.ifsp.biblioteca.domain.Livro;
import br.edu.ifsp.biblioteca.exception.RegraDeNegocioException;
import br.edu.ifsp.biblioteca.repository.ILivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class LivroService {

    private final ILivroRepository livroRepository;

    public LivroService(ILivroRepository rep){
        this.livroRepository = rep;
    }

    public Livro cadastrar(Livro livro){
        if(livro.getTitulo() == null || livro.getTitulo().isEmpty()){
            throw new RegraDeNegocioException("O título é obrigatório!");
        }
        if(livro.getIsbn() == null || livro.getIsbn().isEmpty()){
            throw new RegraDeNegocioException("ISBN é obrigatório!");
        }
        if(livro.getAnoPublicacao() <= 0){
            throw new RegraDeNegocioException("O ano de publicação deve ser maior que zero!");
        }
        Optional<Livro> livroJaCadastradoOptional = this.livroRepository.buscarPorIsbn(livro.getIsbn());

        if(livroJaCadastradoOptional.isPresent()){
            throw new RegraDeNegocioException("Já existe um livro cadastrado com o ISBN: " + livro.getIsbn());
        }

        Livro livroCadastrado = this.livroRepository.salvar(livro);
        return livroCadastrado;
    }

    public Livro adicionarExemplar(Long livroId, String codExemplar){
            Livro livro = this.buscarPorId(livroId);
            livro.adicionarExemplar(new Exemplar(codExemplar, livro));
            return this.livroRepository.salvar(livro);

    }

    public Livro addAutor(Long livroId, String nomeAutor){
        Livro livroEncontrado = this.buscarPorId(livroId);
        livroEncontrado.addAutor(new Autor(nomeAutor));
        return this.livroRepository.salvar(livroEncontrado);

    }

    public Livro buscarPorId(Long id){
        Optional<Livro> livroOptional = this.livroRepository.buscarPorId(id);
        if (livroOptional.isPresent()){
            return livroOptional.get();
        }
        throw new RegraDeNegocioException("Livro não encontrado:" + id);
    }

    public List<Livro> buscarPorTitulo(String trechoTitulo) {
        return this.livroRepository.buscarPorTitulo(trechoTitulo);
    }

    public List<Livro> listarTodos(){
        return this.livroRepository.listarTodos();
    }

}
