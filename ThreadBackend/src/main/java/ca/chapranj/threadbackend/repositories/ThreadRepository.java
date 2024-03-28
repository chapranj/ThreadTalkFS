package ca.chapranj.threadbackend.repositories;

import ca.chapranj.threadbackend.beans.Thread;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ThreadRepository extends MongoRepository<Thread, String> {

}
