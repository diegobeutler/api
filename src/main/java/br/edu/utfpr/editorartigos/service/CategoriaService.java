package br.edu.utfpr.editorartigos.service;

import br.edu.utfpr.editorartigos.model.Categoria;

import java.util.List;

public interface CategoriaService extends CrudService<Categoria, Long> {

    Categoria cadastrarCategoria(Categoria categoria) throws Exception;

    void deletarCategoria(Long id);

    List<Categoria> listarTodos();
}
