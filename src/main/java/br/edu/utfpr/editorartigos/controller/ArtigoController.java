package br.edu.utfpr.editorartigos.controller;

import br.edu.utfpr.editorartigos.model.Artigo;
import br.edu.utfpr.editorartigos.service.ArtigoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("artigo/")
@RequiredArgsConstructor
public class ArtigoController {
    private final ArtigoService artigoService;

    @PostMapping("incluir")
    private Artigo incluir(@RequestBody Artigo artigo) throws Exception {
        return artigoService.cadastrarArtigo(artigo);
    }

    @PutMapping("atualizar")
    private Artigo alterar(@RequestBody Artigo artigo) throws Exception {
        return artigoService.cadastrarArtigo(artigo);
    }

    @DeleteMapping("{id}")
    private void excluir(@PathVariable("id") Long id) {
        artigoService.deletarArtigo(id);
    }


    @GetMapping("pesquisar-todos")
    private List<Artigo> pesquisarTodos() {
        return artigoService.listarTodos();
    }

    @GetMapping("{id}")
    private Artigo findOne(@PathVariable("id") Long id) {
        return artigoService.findById(id);
    }

}
