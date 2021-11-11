package br.edu.utfpr.editorartigos.service;

import br.edu.utfpr.editorartigos.model.Artigo;

public interface ArtigoService extends CrudService<Artigo, Long> {

    Artigo cadastrarArtigo(Artigo artigo) throws Exception;

    void deletarArtigo(Long id);
}
