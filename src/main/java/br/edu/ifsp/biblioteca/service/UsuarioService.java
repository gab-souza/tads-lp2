package br.edu.ifsp.biblioteca.service;

import br.edu.ifsp.biblioteca.domain.Usuario;
import br.edu.ifsp.biblioteca.exception.RegraDeNegocioException;
import br.edu.ifsp.biblioteca.repository.IUsuarioRepository;

import java.util.Optional;

public class UsuarioService {
    private final IUsuarioRepository usuarioRepository;

    public UsuarioService(IUsuarioRepository rep) {
        this.usuarioRepository = rep;
    }

    public Usuario cadastrar(Usuario u) {
        if (u.getNome() == null || u.getNome().isEmpty()) {
            throw new RegraDeNegocioException("Nome é obrigatório");
        }
        if (u.getEmail() == null || u.getEmail().isEmpty()) {
            throw new RegraDeNegocioException("E-mail é obrigatório");
        }
        this.validarEmail(u.getEmail());

        return this.usuarioRepository.salvar(u);
    }

    public Usuario buscarPorId(Long id){
        Optional<Usuario> usuarioOptional = this.usuarioRepository.buscarPorId(id);
        if(usuarioOptional.isPresent()){
            return usuarioOptional.get();
        }
        throw new RegraDeNegocioException("Usuário não encontrado: "+ id);
    }

    public void validarEmail(String email) {
        Optional<Usuario> usuarioOptional = usuarioRepository.buscarPorEmail(email);

        if (usuarioOptional.isPresent()) {
            throw new RegraDeNegocioException("Já existe um usuário cadastrado com o e-mail: " + email);
        }

    }
}