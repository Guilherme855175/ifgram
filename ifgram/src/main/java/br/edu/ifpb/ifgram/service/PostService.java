package br.edu.ifpb.ifgram.service;

import br.edu.ifpb.ifgram.dto.PostRequest;
import br.edu.ifpb.ifgram.dto.PostResponse;
import br.edu.ifpb.ifgram.dto.UserRequest;
import br.edu.ifpb.ifgram.dto.UserResponse;
import br.edu.ifpb.ifgram.model.User;
import br.edu.ifpb.ifgram.repository.Postrepository;

import br.edu.ifpb.ifgram.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

public class PostService{

    private final UserRepository userRepository;
    private final  Postrepository postrepository;


    public PostService(UserRepository userRepository, Postrepository postrepository) {
        this.userRepository = userRepository;
        this.postrepository = postrepository;
    }

    @Transactional
    public PostResponse criar(PostRequest request){
        User autor = userRepository.findById(request,autorId())
                .orElseThrow() ->
        new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                reason: "Nao foi possivel criar a publicacao: usuario nao encontrado"
        )

    }


}

