package ca.chapranj.threadbackend.Services;

import ca.chapranj.threadbackend.repositories.ThreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThreadService {
    @Autowired
    private ThreadRepository threadRepo;

}
