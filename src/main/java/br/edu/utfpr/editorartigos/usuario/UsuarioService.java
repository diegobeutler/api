package br.edu.utfpr.editorartigos.usuario;

import br.edu.utfpr.editorartigos.crud.CrudService;

public interface UsuarioService extends CrudService<Usuario, Long> {
    Usuario criarUsuario(Usuario usuario) throws Exception;
}
