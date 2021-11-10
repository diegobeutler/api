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

    @DeleteMapping("excluir")
    private void excluir(@RequestBody Long id) throws Exception {
        categoriaService.deletarCategoria(id);
    }



}
