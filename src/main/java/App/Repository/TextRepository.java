package App.Repository;

import App.Model.Text;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TextRepository extends MongoRepository<Text, Integer> {
    @Query("{speaker:'?0'}")
    List<Text> findAllMessagesFromSender(String speaker);
}
