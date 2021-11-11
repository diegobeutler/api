package br.edu.utfpr.editorartigos.service.impl;

import br.edu.utfpr.editorartigos.exception.CategoriaJaExisteException;
import br.edu.utfpr.editorartigos.model.Categoria;
import br.edu.utfpr.editorartigos.repository.CategoriaRepository;
import br.edu.utfpr.editorartigos.service.CategoriaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoriaServiceImplTest {

    private CategoriaService categoriaService;

    @Mock
    private CategoriaRepository categoriaRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        categoriaService = new CategoriaServiceImpl(categoriaRepository);
    }

    CategoriaServiceImplTest() {
    }

    @Test()
    void invalidSaveCategoria() {
        var categoria = new Categoria(1L, "receitas");
        when(categoriaRepository.findCategoriaByDescricao("receitas")).thenReturn(Optional.of(categoria));
        Assertions.assertThrows(CategoriaJaExisteException.class,() ->  categoriaService.cadastrarCategoria(categoria));
    }

    @Test()
    void validSaveCategoria() throws Exception {
        var categoria = new Categoria(1L, "receitas");
        when(categoriaRepository.findCategoriaByDescricao("receitas")).thenReturn(Optional.empty());

        categoriaService.cadastrarCategoria(categoria);
        verify(categoriaRepository,times(1)).save(any());
    }

    @Test
    void cadastrarCategoria() {
    }

    @Test
    void deletarCategoria() {
    }
}