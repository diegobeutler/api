package br.edu.utfpr.editorartigos.controller;

import br.edu.utfpr.editorartigos.model.Categoria;
import br.edu.utfpr.editorartigos.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @PostMapping("incluir")
    private Categoria incluir(@Valid @RequestBody Categoria categoria) throws Exception {
        return categoriaService.cadastrarCategoria(categoria);
    }

    @PostMapping("alterar")
    private Categoria alterar(@Valid @RequestBody Categoria categoria) throws Exception {
        return categoriaService.cadastrarCategoria(categoria);
    }

    @DeleteMapping("excluir")
    private void excluir(@RequestBody Long id) throws Exception {
        categoriaService.deletarCategoria(id);
    }



}
