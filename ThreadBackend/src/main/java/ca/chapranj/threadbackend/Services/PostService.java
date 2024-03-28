package ca.chapranj.threadbackend.Services;

import ca.chapranj.threadbackend.beans.Post;
import ca.chapranj.threadbackend.beans.Thread;
import ca.chapranj.threadbackend.repositories.PostRepository;
import ca.chapranj.threadbackend.repositories.ThreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository postRepo;

    @Autowired
    ThreadRepository threadRepo;


    public Post addPostToThread(String threadId, Post post){
        Thread thread = threadRepo.findById(threadId).orElse(null);
        if (thread != null){
            System.out.println(post);
            return postRepo.save(post);
        }
        return null;
    }

    public List<Post> getPostsByThreadId(String threadId){
        Thread thread = threadRepo.findById(threadId).orElse(null);
        if (thread != null){
            return postRepo.findByThreadId(threadId);
        }
        return null;

    }

}
