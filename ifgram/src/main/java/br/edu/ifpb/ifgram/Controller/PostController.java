package br.edu.ifpb.ifgram.Controller;

import br.edu.ifpb.ifgram.dto.PostRequest;
import br.edu.ifpb.ifgram.dto.PostResponse;
import br.edu.ifpb.ifgram.service.PostService;

import jakarta.persistence.Id;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {

    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping
    public List<PostResponse> listarFeed() {
        return service.listarFeed();
    }

    @GetMapping("/{id}")
    public PostResponse buscarPorId(@PathVariable Long id) {
        PostResponse post = service.buscarPorId(id);
        return PostResponse.from(post);
    }

    @GetMapping("/autor/{autorId}")
    public List<PostResponse> listarPorAutor(
            @PathVariable Long autorId) {
        return Collections.singletonList(service.buscarPorId(autorId));
    }

    @PostMapping
    public PostResponse criar(
            @Valid @RequestBody PostRequest request) {
        return service.criar(request);
    }


    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
