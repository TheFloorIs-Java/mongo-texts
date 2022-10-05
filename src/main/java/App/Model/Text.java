package App.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Document("text")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Text {
    @Id
    public BigInteger messageId;
    public String messageText;
    public String speaker;
    public String date;
    public String time;
    public String location;
}
