package br.edu.ifsp.biblioteca.cli;

import br.edu.ifsp.biblioteca.repository.LivroRepositoryEmMemoria;
import br.edu.ifsp.biblioteca.repository.UsuarioRepositoryEmMemoria;
import br.edu.ifsp.biblioteca.service.LivroService;
import br.edu.ifsp.biblioteca.service.UsuarioService;

public class CatalogoRunner {
    private final LivroService livroService;
    private final UsuarioService usuarioService;

    public CatalogoRunner(){
        this.livroService = new LivroService(
                new LivroRepositoryEmMemoria()
        );
        this.usuarioService = new UsuarioService(
                new UsuarioRepositoryEmMemoria()
        );

    }
}
