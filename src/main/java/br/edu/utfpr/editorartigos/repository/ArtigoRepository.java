package br.edu.utfpr.editorartigos.repository;

import br.edu.utfpr.editorartigos.model.Artigo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface ArtigoRepository extends JpaRepository<Artigo, Long> {
    Set<Artigo> findArtigosByAutorId(Long id);

    Set<Artigo> findArtigosByCategoria_IdIn(Set<Long> ids);

    Optional<Artigo> findArtigoByCategoria_Id(Long id);

    Set<Artigo> findTop10ByOrderByVisualizacoesDesc();
}
