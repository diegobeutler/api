package br.edu.utfpr.editorartigos.service;

import br.edu.utfpr.editorartigos.model.Categoria;

public interface CategoriaService extends CrudService<Categoria, Long> {

    Categoria cadastrarCategoria(Categoria categoria) throws Exception;

    void deletarCategoria(Long id);
}
