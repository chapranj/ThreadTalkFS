package ca.chapranj.threadbackend.controllers;

import ca.chapranj.threadbackend.Services.PostService;
import ca.chapranj.threadbackend.beans.Post;
import ca.chapranj.threadbackend.beans.Thread;
import ca.chapranj.threadbackend.repositories.PostRepository;
import ca.chapranj.threadbackend.repositories.ThreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TheController {

    @Autowired
    PostRepository postRepo;

    @Autowired
    ThreadRepository threadRepo;

    @Autowired
    PostService postService;

    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        return postRepo.findAll();
    }

    @GetMapping("/threads")
    public List<Thread> getAllThreads(){
        return threadRepo.findAll();
    }

    //inserts a new thread
    @PostMapping("/threads")
    public Thread addThread(@RequestBody Thread thread){
        return threadRepo.save(thread);
    }

    //inserts post within the thread with threadId {threadId}
    @PostMapping("/threads/{threadId}")
    public Post addPostToThread(@PathVariable String threadId, @RequestBody Post post){
        return postService.addPostToThread(threadId, post);
    }

    //gets All the posts within the threadId {threadId}
    @GetMapping("/threads/{threadId}")
    public List<Post> getPostsByThreadId(@PathVariable String threadId){
        return postRepo.findByThreadId(threadId);
    }


}
