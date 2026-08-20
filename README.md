# Sistema de Biblioteca — LP2 · 2026/2

Projeto da disciplina **Linguagem de Programação 2** (TADS · IFSP-SPO).
Este repositório é construído em sala, aula a aula, durante o semestre.

## Antes da primeira aula

Você precisa de:

- **JDK 21** — confira com `java -version` (tem que aparecer `21`)
- **Maven** — confira com `mvn -version` (ou use o Maven embutido da IDE)
- **Git** — confira com `git --version`
- Uma IDE: IntelliJ IDEA Community, VS Code (com o Extension Pack for Java) ou Eclipse

## Como rodar

```bash
git clone <url-deste-repositorio>
cd biblioteca
mvn spring-boot:run
```

Deve aparecer no console:

```
=========================================
  Biblioteca IFSP - ambiente OK
  Java: 21.x.x
=========================================
```

Viu essa mensagem? Seu ambiente está pronto. **Não viu? Chegue cedo na aula
e me procure** — ambiente quebrado no meio da aula custa a aula inteira.

Para rodar os testes:

```bash
mvn test
```

## Como acompanhar as aulas

Ao fim de cada encontro o código do dia é marcado com uma etiqueta:

```bash
git pull
git tag                  # lista as aulas disponiveis
git checkout aula-03     # ve o codigo como ele terminou na aula 03
git checkout main        # volta para a versao mais recente
```

**Faltou a uma aula?** Use `git checkout aula-NN` para ver exatamente o que
foi construído, e `git diff aula-03 aula-04` para ver o que mudou de uma
aula para a outra.

## Como entregar

As entregas são feitas **no seu próprio repositório**, com etiquetas:

```bash
git tag checkpoint-01
git push --tags
```

O calendário dos checkpoints está no Moodle.
