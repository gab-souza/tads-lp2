package br.edu.ifsp.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
@SpringBootApplication
public class BibliotecaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BibliotecaApplication.class, args);
    }
}
