package ca.chapranj.threadbackend.controllers;

import ca.chapranj.threadbackend.Services.PostService;
import ca.chapranj.threadbackend.Services.ThreadService;
import ca.chapranj.threadbackend.beans.Post;
import ca.chapranj.threadbackend.beans.Thread;
import ca.chapranj.threadbackend.repositories.PostRepository;
import ca.chapranj.threadbackend.repositories.ThreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TheController {

    @Autowired
    ThreadRepository threadRepo;

    @Autowired
    PostRepository postRepo;

    @Autowired
    ThreadService threadService;

    @Autowired
    PostService postService;


//    @GetMapping("/posts")
//    public List<Post> getAllPosts(){
//        return threadRepo.getAllPosts();
//    }

    @GetMapping("/threads")
    public List<Thread> getAllThreads(){
        return threadRepo.findAll();
    }

    @GetMapping("/threads/{threadId}")
    public Thread getThread(@PathVariable String threadId ){
        return threadRepo.findById(threadId).orElse(null);
    }

    //inserts a new thread
    @PostMapping("/threads")
    public Thread addThread(@RequestBody Thread thread){
        return threadRepo.save(thread);
    }

    //inserts post within the thread with threadId {threadId}
    @PostMapping("/posts/{threadId}")
    public Post addPostToThread(@PathVariable String threadId, @RequestBody Post post){
        return postService.addPostToThread(threadId, post);
    }

//    gets All the posts within the threadId {threadId}
    @GetMapping("/posts/{threadId}")
    public List<Post> getPostsByThreadId(@PathVariable String threadId){
        System.out.println("getting posts");
        return postService.getPostsByThreadId(threadId);
    }

    @DeleteMapping("/threads/{threadId}")
    public void deleteThread(@PathVariable String threadId){
       threadService.deleteSingleThread(threadId);
    }



}
