package ca.chapranj.threadbackend.repositories;


import ca.chapranj.threadbackend.beans.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByThreadId(String threadId);

}
