package br.edu.ifpb.ifgram.repository;

import br.edu.ifpb.ifgram.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Postrepository extends JpaRepository<Post, Long> {

    List<Postrepository> findByAutorId(Long autorId);

    List<Postrepository> findByLegendaContainingIgnoreCase(String trecho);

    long countByAutorId(Long autorId);

    @Query("SELECT p FROM Post p ORDER BY p.criadoEm DESC")
    List<Post> buscarFeed();
}
