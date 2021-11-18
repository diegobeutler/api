package br.edu.utfpr.editorartigos.repository;

import br.edu.utfpr.editorartigos.model.Artigo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ArtigoRepository extends JpaRepository<Artigo, Long> {
}
