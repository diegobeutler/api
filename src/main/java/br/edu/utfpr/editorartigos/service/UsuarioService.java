package br.edu.utfpr.editorartigos.service;

import br.edu.utfpr.editorartigos.model.Usuario;

import java.util.List;

public interface UsuarioService extends CrudService<Usuario, Long> {
    Usuario getUsuarioLogado();

    Usuario cadastrarUsuario(Usuario usuario) throws Exception;

    void deletarUsuario(Long id);

    List<Usuario> listarTodos();


}
