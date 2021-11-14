package br.edu.utfpr.editorartigos.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Artigo implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, unique = true)
        private String descricao;

        @Column(nullable = false)
        private String titulo;

        @Column(nullable = false)
        private String palavrasChave;

        @Lob
        @Column(nullable = false)
        private String texto;

        @ManyToOne
        @JoinColumn(name = "id_categoria")
        private Categoria categoria;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "id_usuario")
        private Usuario autor;

        public void setPalavrasChave(ArrayList<String> palavrasChave) {
                this.palavrasChave = palavrasChave.toString();
        }
}
