
package br.edu.ifpb.ifgram.service;

import br.edu.ifpb.ifgram.dto.CommentRequest;
import br.edu.ifpb.ifgram.dto.CommentResponse;
import br.edu.ifpb.ifgram.model.Comment;
import br.edu.ifpb.ifgram.model.Post;
import br.edu.ifpb.ifgram.model.User;
import br.edu.ifpb.ifgram.repository.CommentRepository;
import br.edu.ifpb.ifgram.repository.Postrepository;
import br.edu.ifpb.ifgram.repository.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final Postrepository postRepository;
    private final UserRepository userRepository;

    public CommentService(
            CommentRepository commentRepository,
            Postrepository postRepository,
            UserRepository userRepository) {

        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public CommentResponse criar(CommentRequest request) {

        if (request.texto() == null || request.texto().isBlank()) {
            throw new RuntimeException("O comentário não pode estar vazio");
        }

        Post post = postRepository.findById(request.postId())
                .orElseThrow(() ->
                        new RuntimeException("Post não encontrado"));

        User autor = userRepository.findById(request.autorId())
                .orElseThrow(() ->
                        new RuntimeException("Usuário não encontrado"));

        Comment comment = new Comment(
                request.texto(),
                post,
                autor
        );

        comment = commentRepository.save(comment);

        return CommentResponse.from(comment);
    }

    public List<CommentResponse> listarPorPost(Long postId) {

        return commentRepository
                .findByPostIdOrderByCriadoEmAsc(postId)
                .stream()
                .map(CommentResponse::from)
                .toList();
    }

    @Transactional
    public void deletar(Long id) {

        Comment comment = commentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Comentário não encontrado"));

        commentRepository.delete(comment);
    }
}
