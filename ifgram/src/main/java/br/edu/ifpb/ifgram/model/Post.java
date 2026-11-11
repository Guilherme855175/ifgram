package br.edu.ifpb.ifgram.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name ="tb_post" )
public class Post {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

   @Column(nullable = false)
   private String imagemUrl;

   @Column(length = 300)
   private String legenda;

   private LocalDateTime criadoEm;

   public Post(String imagemUrl, String legenda) {
      this.criadoEm = LocalDateTime.now();
   }

   @ManyToOne(optional = false)
   @JoinColumn(name = "user_id")
   private User autor;

   public Post() {
   }
   public Post(String imagemUrl,String legenda , User autor ) {
   this.imagemUrl = imagemUrl;
   this.legenda = legenda;
   this.autor = autor;
   }
   public String getImagemUrl() {
      return imagemUrl;
   }
   public String getLegenda() {
      return legenda;
   }
   public User getAutor() {
      return autor;
   }

   public long getId() {
      return id;
   }

   public LocalDateTime getCriadoEm() {
      return criadoEm;
   }

   public void setId(long id) {
      this.id = id;
   }

   public void setImagemUrl(String imagemUrl) {
      this.imagemUrl = imagemUrl;
   }

   public void setLegenda(String legenda) {
      this.legenda = legenda;
   }

   public void setCriadoEm(LocalDateTime criadoEm) {
      this.criadoEm = criadoEm;
   }

   public void setAutor(User autor) {
      this.autor = autor;
   }
}
