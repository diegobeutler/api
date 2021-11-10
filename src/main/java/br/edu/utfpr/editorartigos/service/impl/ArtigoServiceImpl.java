package br.edu.utfpr.editorartigos.service.impl;

import br.edu.utfpr.editorartigos.model.Artigo;
import br.edu.utfpr.editorartigos.repository.ArtigoRepository;
import br.edu.utfpr.editorartigos.service.ArtigoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArtigoServiceImpl extends CrudServiceImpl<Artigo, Long> implements ArtigoService {

    private final ArtigoRepository artigoRepository;

    @Override
    public JpaRepository<Artigo, Long> getRepository() {
        return artigoRepository;
    }

    @Override
    public void valid(Artigo entity) throws Exception {

    }

    @Override
    public Artigo cadastrarArtigo(Artigo categoria) throws Exception {
        return save(categoria);
    }

    @Override
    public void deletarArtigo(Long id) {
        delete(id);
    }


}
