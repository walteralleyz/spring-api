package br.com.alura.forum.repository;

import br.com.alura.forum.modelo.Curso;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class CursoRepositoryTest {

    @Autowired
    private CursoRepository cursoRepository;

    @Test
    public void deveriaEncontrarUmCursoAoBuscarPeloNome() {
        String nomeCurso = "HTML 5";
        Curso curso = cursoRepository.findByNome(nomeCurso);

        Assertions.assertNotNull(curso);
        Assertions.assertEquals(nomeCurso, curso.getNome());
    }

    @Test
    public void naoDeveriaEncontrarOCurso() {
        String nomeCurso = "JPA";
        Curso curso = cursoRepository.findByNome(nomeCurso);

        Assertions.assertNull(curso);
    }
}
