package ca.chapranj.threadbackend.Services;

import ca.chapranj.threadbackend.beans.Post;
import ca.chapranj.threadbackend.beans.Thread;
import ca.chapranj.threadbackend.repositories.PostRepository;
import ca.chapranj.threadbackend.repositories.ThreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThreadService {
    @Autowired
    private ThreadRepository threadRepo;

    @Autowired
    private PostRepository postRepo;

    public void deleteSingleThread(String threadId){
        postRepo.deleteAllByThreadId(threadId);
        threadRepo.deleteById(threadId);
    }





}
