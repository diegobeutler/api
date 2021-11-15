package br.edu.utfpr.editorartigos.controller;

import br.edu.utfpr.editorartigos.model.Usuario;
import br.edu.utfpr.editorartigos.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;


    @PostMapping("incluir")
    private Usuario incluir(@RequestBody Usuario usuario) throws Exception {
        return usuarioService.cadastrarUsuario(usuario);
    }

    @PutMapping("atualizar")
    private Usuario atualizar(@RequestBody Usuario usuario) throws Exception {
        return usuarioService.cadastrarUsuario(usuario);
    }

    @DeleteMapping("excluir")
    private void excluir(@RequestBody Long id) throws Exception {
        usuarioService.deletarUsuario(id);
    }

    @GetMapping("pesquisar-todos")
    private List<Usuario> pesquisarTodos() {
        return usuarioService.listarTodos();
    }

    @GetMapping("{id}")
    private Usuario findOne(@PathVariable("id") Long id) {
        return usuarioService.findById(id);
    }

}
