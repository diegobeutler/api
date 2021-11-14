package br.edu.utfpr.editorartigos.service.impl;

import br.edu.utfpr.editorartigos.model.Artigo;
import br.edu.utfpr.editorartigos.repository.ArtigoRepository;
import br.edu.utfpr.editorartigos.service.ArtigoService;
import br.edu.utfpr.editorartigos.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArtigoServiceImpl extends CrudServiceImpl<Artigo, Long> implements ArtigoService {

    private final ArtigoRepository artigoRepository;
    private final UsuarioService usuarioService;

    @Override
    public JpaRepository<Artigo, Long> getRepository() {
        return artigoRepository;
    }

    @Override
    public void valid(Artigo entity) throws Exception {

    }

    @Override
    public Artigo cadastrarArtigo(Artigo artigo) throws Exception {
//        if (artigo.getId() == null) {
//            artigo.setAutor(usuarioService.getUsuarioLogado());
//        }
        artigo.setAutor(usuarioService.findOne(1L));// todo remover após feito a parte de login
        return save(artigo);
    }

    @Override
    public void deletarArtigo(Long id) {
        delete(id);
    }

    @Override
    public List<Artigo> listarTodos() {
        return findAll();
    }
}
