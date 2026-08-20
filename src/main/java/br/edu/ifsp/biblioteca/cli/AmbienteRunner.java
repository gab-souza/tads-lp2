package br.edu.ifsp.biblioteca.cli;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Classe temporaria: existe apenas para confirmar que o ambiente de cada
 * um esta funcionando (JDK 21, Maven, IDE e Spring Boot subindo).
 *
 * Se voce rodou o projeto e viu a mensagem abaixo no console, seu ambiente
 * esta pronto. Esta classe sera substituida na primeira aula.
 */
@Component
public class AmbienteRunner implements CommandLineRunner {

    @Override
    public void run(String... args) {
        System.out.println();
        System.out.println("=========================================");
        System.out.println("  Biblioteca IFSP - ambiente OK");
        System.out.println("  Java: " + System.getProperty("java.version"));
        System.out.println("=========================================");
        System.out.println();
    }
}
