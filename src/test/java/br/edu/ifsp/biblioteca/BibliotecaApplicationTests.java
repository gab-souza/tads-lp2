package br.edu.ifsp.biblioteca;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Teste de fumaca: verifica que o contexto do Spring sobe sem erro.
 *
 * Se "mvn test" passar aqui, seu ambiente esta pronto para a disciplina.
 */
@SpringBootTest
class BibliotecaApplicationTests {

    @Test
    void contextoSobe() {
        // Sem assercao: o teste falha sozinho se o contexto nao subir.
    }
}
