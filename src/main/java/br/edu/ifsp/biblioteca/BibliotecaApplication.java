package br.edu.ifsp.biblioteca;
import br.edu.ifsp.biblioteca.domain.Livro;

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
            1L,
           "9788508145607",
            "Dom Casmurro",
           2026
        );
        Livro livro2 = new Livro(
                2L,
                "9788573264579",
                "Dom Quixote",
                2025
        );
        Livro livro3 = new Livro(
                3L,
                "9788573266467",
                "Crime e Castigo",
                2024
        );
        System.out.println(livro);
    }
}
