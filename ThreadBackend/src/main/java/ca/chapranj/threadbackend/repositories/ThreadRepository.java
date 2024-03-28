package ca.chapranj.threadbackend.repositories;

import ca.chapranj.threadbackend.beans.Thread;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ThreadRepository extends MongoRepository<Thread, String> {

    void deleteById(String threadId);
}
