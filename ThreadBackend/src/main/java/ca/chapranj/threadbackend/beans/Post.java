package ca.chapranj.threadbackend.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "posts")
public class Post {
    @Id
    private String id;
    private String content;
    private String username;
    private String threadId;
}
