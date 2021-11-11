package br.edu.utfpr.editorartigos.controller;

import br.edu.utfpr.editorartigos.model.Categoria;
import br.edu.utfpr.editorartigos.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categoria")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @PostMapping("incluir")
    private Categoria incluir(@RequestBody Categoria categoria) throws Exception {
        return categoriaService.cadastrarCategoria(categoria);
    }

    @PostMapping("alterar")
    private Categoria alterar(@RequestBody Categoria categoria) throws Exception {
        return categoriaService.cadastrarCategoria(categoria);
    }

    @DeleteMapping
    private void excluir(@RequestBody Long id) {
        categoriaService.deletarCategoria(id);
    }

    @GetMapping("pesquisar-todos")
    private void pesquisarTodos() {
        categoriaService.listarTodos();
    }

    @GetMapping("{id}")
    private Categoria findOne(@PathVariable("id") Long id) {
        return categoriaService.findOne(id);
    }
}
