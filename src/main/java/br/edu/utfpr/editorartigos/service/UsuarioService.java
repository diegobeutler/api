package br.edu.utfpr.editorartigos.service;

import br.edu.utfpr.editorartigos.model.Usuario;

public interface UsuarioService extends CrudService<Usuario, Long> {
    Usuario criarUsuario(Usuario usuario) throws Exception;
}
