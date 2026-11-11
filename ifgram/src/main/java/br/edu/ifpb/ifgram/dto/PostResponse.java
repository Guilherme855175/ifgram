package br.edu.ifpb.ifgram.dto;

import br.edu.ifpb.ifgram.model.Post;
import br.edu.ifpb.ifgram.model.User;

import java.time.LocalDateTime;

public record PostResponse(long id, String imagemUrl, String legenda, LocalDateTime criadoEm, long  autorId , String autorNome) {


    public static PostResponse from(Post post) {

        return new PostResponse(post.getId(),post.getImagemUrl(),post.getLegenda(),post.getCriadoEm(),post.getAutor().getId(), post.getAutor().getNome() );


    }

}

