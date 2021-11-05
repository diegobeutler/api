package br.edu.utfpr.editorartigos.repository;

import br.edu.utfpr.editorartigos.model.Artigo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtigoRepository extends JpaRepository<Artigo, Long> {
}
