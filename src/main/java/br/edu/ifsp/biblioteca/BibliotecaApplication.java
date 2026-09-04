package br.edu.ifsp.biblioteca;
import br.edu.ifsp.biblioteca.domain.Livro;
import br.edu.ifsp.biblioteca.repository.ILivroRepository;
import br.edu.ifsp.biblioteca.repository.LivroRepositoryEmMemoria;

import java.util.List;
import java.util.Optional;

/**
 * Ponto de entrada da aplicacao.
 *
 * @SpringBootApplication liga tres coisas de uma vez:
 *   - @Configuration      (esta classe pode declarar beans)
 *   - @EnableAutoConfiguration (o Boot configura o que achar no classpath)
 *   - @ComponentScan      (procura @Service/@Repository/@Component DESTE
 *                          pacote para baixo — por isso todo o codigo
 *                          fica sob br.edu.ifsp.biblioteca)
 */
public class BibliotecaApplication {

    public static void main(String[] args) {
        Livro livro = new Livro(
           "9788508145607",
            "Dom Casmurro",
           2026
        );
        Livro livro2 = new Livro(
                "9788573264579",
                "Dom Quixote",
                2025
        );
        Livro livro3 = new Livro(
                "9788573266467",
                "Crime e Castigo",
                2024
        );
        ILivroRepository livroRespository = new LivroRepositoryEmMemoria();
        livroRespository.salvar(livro);
        livroRespository.salvar(livro);
        livroRespository.salvar(livro2);
        livroRespository.salvar(livro3);

        Optional<Livro> livro1Optional = livroRespository.buscarPorId(1L);
        Optional<Livro> livro2Optional = livroRespository.buscarPorId(10L);

        if(livro1Optional.isPresent()){
           Livro l1 = livro1Optional.get();
           System.out.println("Livro com ID 1 encontrado: " + l1);
        }
        if(livro2Optional.isPresent()){
            Livro l2 = livro2Optional.get();
            System.out.println("Livro com ID 10 encontrado: " + l2);
        } else {
            System.out.println("Livro com ID 10 não encontrado!");
        }

        List<Livro> encontrados = livroRespository.buscarPorTitulo("Casmurro");
        System.out.println(encontrados);
        //System.out.println(livro);


    }
}
