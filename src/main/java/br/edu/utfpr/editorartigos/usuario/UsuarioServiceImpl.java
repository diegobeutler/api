package br.edu.utfpr.editorartigos.usuario;

import br.edu.utfpr.editorartigos.crud.CrudServiceImpl;
import br.edu.utfpr.editorartigos.exception.UsuarioJaExisteException;
import br.edu.utfpr.editorartigos.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl extends CrudServiceImpl<Usuario, Long> implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public JpaRepository<Usuario, Long> getRepository() {
        return usuarioRepository;
    }

    @Override
    public Usuario criarUsuario(Usuario usuario) throws Exception {
        return save(usuario);
    }

    @Override
    public void valid(Usuario entity) throws UsuarioJaExisteException {
        if (usuarioRepository.findUsuarioByUsername(entity.getUsername()).isPresent())
            throw new UsuarioJaExisteException("Usuario " + entity.getUsername() + " já existe");
    }
}
