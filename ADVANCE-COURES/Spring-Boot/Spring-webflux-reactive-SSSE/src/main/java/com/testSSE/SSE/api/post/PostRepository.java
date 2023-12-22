package com.testSSE.SSE.api.post;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends ReactiveMongoRepository<Post, String> {

    Optional<Post> findPostById(String id);
}
