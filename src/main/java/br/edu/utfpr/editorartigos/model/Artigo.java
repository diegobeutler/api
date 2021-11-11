package br.edu.utfpr.editorartigos.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Artigo {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, unique = true)
        private String descricao;

        @Column(nullable = false)
        private String titulo;

        @Column(nullable = false)
        private String subtitulo;

        @Column(nullable = false)
        private String palavrasChave;

        @Lob
        @Column(nullable = false)
        private String texto;

        @ManyToOne
        @JoinColumn(name = "id_categoria")
        private Categoria categoria;

        @ManyToOne
        @JoinColumn(name = "id_usuario")
        private Usuario autor;

}
