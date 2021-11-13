package br.edu.utfpr.editorartigos.service.impl;

import br.edu.utfpr.editorartigos.exception.UsuarioJaExisteException;
import br.edu.utfpr.editorartigos.model.Categoria;
import br.edu.utfpr.editorartigos.model.Usuario;
import br.edu.utfpr.editorartigos.repository.PermissaoRepository;
import br.edu.utfpr.editorartigos.repository.UsuarioRepository;
import br.edu.utfpr.editorartigos.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl extends CrudServiceImpl<Usuario, Long> implements UsuarioService, UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder encoder;

    private PermissaoRepository permissaoRepository;


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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findUsuarioByUsername(username);
        if (usuario.isEmpty()) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        return usuario.get();
    }

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) throws Exception {
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        usuario.setPermissoes(Set.of(permissaoRepository.findByNome("ROLE_USER")));
        return save(usuario);
    }

    @Override
    public void deletarUsuario(Long id) {
        delete(id);
    }

    @Override
    public List<Usuario> listarTodos() {
        return findAll();
    }

    @Override
    public Usuario getUsuarioLogado() {
        return (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
