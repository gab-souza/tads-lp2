package br.edu.ifsp.biblioteca.repository;

import br.edu.ifsp.biblioteca.domain.Usuario;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface IUsuarioRepository {
    Usuario salvar(Usuario u);

    Optional<Usuario> buscarPorId(Long id);

    Optional<Usuario> buscarPorEmail(String email);

    List<Usuario> listarTodos();

}
