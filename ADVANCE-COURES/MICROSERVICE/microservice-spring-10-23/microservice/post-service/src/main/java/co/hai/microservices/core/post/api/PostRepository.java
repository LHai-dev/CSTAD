package co.hai.microservices.core.post.api;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface PostRepository extends ReactiveMongoRepository<Post, String> {

    Optional<Post> findPostById(String id);
}
