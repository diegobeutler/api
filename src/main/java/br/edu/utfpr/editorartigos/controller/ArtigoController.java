package br.edu.utfpr.editorartigos.controller;

import br.edu.utfpr.editorartigos.model.Artigo;
import br.edu.utfpr.editorartigos.service.ArtigoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/artigo")
@RequiredArgsConstructor
public class ArtigoController {
    private final ArtigoService artigoService;

    @PostMapping("incluir")
    private Artigo incluir(@RequestBody Artigo categoria) throws Exception {
        return artigoService.cadastrarArtigo(categoria);
    }

    @PostMapping("alterar")
    private Artigo alterar(@RequestBody Artigo categoria) throws Exception {
        return artigoService.cadastrarArtigo(categoria);
    }

    @DeleteMapping("excluir")
    private void excluir(@RequestBody Long id) throws Exception {
        artigoService.deletarArtigo(id);
    }

}
