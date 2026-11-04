package br.edu.ifpb.ifgram.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name ="tb_post" )
public class Post {

 @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @Column(nullable = false)
    private  String imagemUrl;

    @Column(length = 300)
    private String legenda;

    private LocalDateTime criadoEm;

    public Post(String imagemUrl, String legenda) {
        this.criadoEm = LocalDateTime.now();
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User autor;
}
