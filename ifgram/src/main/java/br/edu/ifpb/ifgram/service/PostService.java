package br.edu.ifpb.ifgram.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifpb.ifgram.model.Post;
import br.edu.ifpb.ifgram.model.User;
import br.edu.ifpb.ifgram.repository.UserRepository;
import br.edu.ifpb.ifgram.repository.Postrepository;
import br.edu.ifpb.ifgram.dto.PostRequest;
import br.edu.ifpb.ifgram.dto.PostResponse;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final UserRepository userRepository;
    private final Postrepository postrepository;


    public PostService(
            Postrepository postrepository,
            UserRepository userRepository
    ) {
        this.postrepository = postrepository;
        this.userRepository = userRepository;

    }

    @Transactional
    public PostResponse criar(PostRequest request) {
        Optional<User> autor = userRepository.findById(request.autorId());
        Post post = new Post(request.imagemUrl(), request.legenda(), autor.get());
        Post postsave = postrepository.save(post);
        PostResponse response = new PostResponse(
                postsave.getId(),
                postsave.getImagemUrl(),
                postsave.getLegenda(),
                postsave.getCriadoEm(),
                postsave.getAutor().getId(),
                postsave.getAutor().getNome()
        );
        return response;
    }


    public List<PostResponse> listarFeed() {
        return postrepository.findAll()
                .stream()
                .map(PostResponse::from)
                .toList();
    }


    public PostResponse buscarPorId(Long id) {
        Post post = postrepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post não encontrado com ID: " + id));

        return PostResponse.from(post);
    }

}