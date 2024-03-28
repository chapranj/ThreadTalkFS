package ca.chapranj.threadbackend.Services;

import ca.chapranj.threadbackend.beans.Post;
import ca.chapranj.threadbackend.beans.Thread;
import ca.chapranj.threadbackend.repositories.PostRepository;
import ca.chapranj.threadbackend.repositories.ThreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepo;

    @Autowired
    private ThreadRepository threadRepo;

    public Post addPostToThread(String threadId, Post post) {
        Thread thread = threadRepo.findById(threadId).orElse(null);
        if (thread != null) {
            post.setThreadId(threadId);
            threadRepo.save(thread);
            System.out.println(thread);
            return postRepo.save(post);
        }
        return null;
    }
}


