package ca.chapranj.threadbackend.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "threads")
public class Thread {
    @Id
    private String id;
    private String title;
    private String username;
}
