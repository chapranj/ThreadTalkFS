package ca.sheridancollege.chapranj.controllers;

import ca.sheridancollege.chapranj.beans.Post;
import ca.sheridancollege.chapranj.beans.Thread;
import ca.sheridancollege.chapranj.database.DatabaseAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RestApiController {
//    @Autowired
//    JdbcUserDetailsManager jdbcUserDetailsManager;

    @Autowired
    private DatabaseAccess da;

    @RequestMapping("/posts")
    public List<Post> getIndex(Model model) {
        return da.selectAllFromPosts();
    }

    @RequestMapping("/")
    public List<Thread> getThreads(Model model) {
        return da.selectAllFromThreads();
    }

//    @GetMapping("/login")
//    public String getLogin() {
//        return "login";
//    }
//
//    //I have added the below method in such a way that when the user is logged in and he clicks the view thread, then he should be served with the posts.html page which doesnt have the delete options
//    // and if the manager logs in, then the viewAdmin.html page will be served which has the delete options.
//
//
//    @GetMapping("/view/{threadId}")
//    public String getPostByThread(Model model, @PathVariable int threadId, Authentication authentication) {
//        for (GrantedAuthority auth : authentication.getAuthorities()) {
//            if ("ROLE_USER".equals(auth.getAuthority())) {
//                model.addAttribute("posts", da.selectPostsByThread(threadId));
//                model.addAttribute("title", da.getThreadName(threadId));
//                model.addAttribute("threadId", threadId);
//                model.addAttribute("post", new Post());
//                System.out.println("Thread id in getPostByThread: " + threadId);
//                return "posts";
//
//            } else if ("ROLE_MANAGER".equals(auth.getAuthority())) {
//                System.out.println("manager detected");
//                model.addAttribute("posts", da.selectPostsByThread(threadId));
//                model.addAttribute("title", da.getThreadName(threadId));
//                model.addAttribute("threadId", threadId);
//                model.addAttribute("post", new Post());
//                System.out.println("Thread id in getPostByThread: " + threadId);
//                return "viewAdmin";
//            }
//        }
//        return "posts";
//
//    }
//

    @PostMapping("/addPost")
    public ResponseEntity<String> addPost(@RequestBody Post post, @RequestParam int threadId) {
        System.out.println("Post: "+post);
        System.out.println(threadId);
        post.setThreadId(threadId);
        int res = da.insertIntoPosts(post);
        if (res > 0) {
            return ResponseEntity.ok("Post added successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add post");
        }

    }

	@GetMapping("/view/{threadId}")
	public ArrayList<Post> getPostByThread(@PathVariable int threadId) {
        return da.selectPostsByThread(threadId);
	}
//    @GetMapping("/startThread")
//    public String getStartThread(Model model) {
//        model.addAttribute("thread", new Thread());
//        return "startThread";
//    }
//
    @PostMapping("/addThread")
    public ResponseEntity<String> addThread(@RequestBody Thread thread) {
        int res = da.insertIntoThreads(thread);
        System.out.println(res);
        if (res > 0) {
            System.out.println("Yes");
            return ResponseEntity.ok("Post added successfully");
        }
        else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add thread");
        }
    }

//    @GetMapping("/viewAdmin")
//    public String getAdminPage() {
//        return "viewAdmin";
//    }
//
//    @GetMapping("/delete/{postId}")
//    public String deleter(@PathVariable int postId, Model model, @RequestParam int threadId) {
//        int res = da.delete(postId);
//        System.out.println(res);
//        return "redirect:/view/" + threadId;
//    }
//
//    @GetMapping("/register")
//    public String register(Model model, UserRegistration user) {
//        model.addAttribute("user", user);
//        return "register";
//    }
//
//
//    @PostMapping("/register")
//    public String processRegister(@ModelAttribute UserRegistration user) {
//        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//        if (user.getAuthority().equalsIgnoreCase("user")) {
//            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//        } else if (user.getAuthority().equalsIgnoreCase("manager")) {
//            authorities.add(new SimpleGrantedAuthority("ROLE_MANAGER"));
//        } else {
//            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//            authorities.add(new SimpleGrantedAuthority("ROLE_MANAGER"));
//        }
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encodedPassword = passwordEncoder.encode(user.getPassword());
//        User newuser = new User(user.getUsername(), encodedPassword, authorities);
//        jdbcUserDetailsManager.createUser(newuser);
//        return "redirect:/";
//    }
//
//    @GetMapping("/manageThreads")
//    public String getManageThreads(Model model) {
//        model.addAttribute("threads", da.selectAllFromThreads());
//        return "manageThreads";
//    }
//
//    @GetMapping("/deleteThread/{threadId}")
//    public String threadDeleter(@PathVariable int threadId, Model model) {
//        int res = da.deleteThread(threadId);
//        System.out.println(res);
//        return "redirect:/";
//    }
//
//    @GetMapping("/access-denied")
//    public String accessDenied() {
//        return "access-denied";
//    }
}
