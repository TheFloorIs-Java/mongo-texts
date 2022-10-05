package App.Service;

import App.Repository.TextRepository;
import App.Model.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
@Service
public class TextService {
    TextRepository textRepository;
    @Autowired
    public TextService(TextRepository textRepository){
        this.textRepository = textRepository;
        List<Text> junkTexts = generateNRandom();
        for(Text t : junkTexts){
            addText(t);
        }
    }
    public List<Text> getAllText(){
        return textRepository.findAll();
    }
    public Text addText(Text text){
        return textRepository.save(text);
    }
    public List<Text> getTextsBySender(String sender){
        return textRepository.findAllMessagesFromSender(sender);
    }
    public List<Text> generateNRandom(){
        List<Text> texts = new ArrayList<>();
        String[] names = {"bob", "dave", "hank", "jill", "nancy", "susan", "xavier", "rob", "daniel", "aaron", "nathan", "brodie", "adam"};
        String[] messages = {"hello", "goodbye", "see you soon", "we are calling you about your vehicles extended warranty", "where are you?"};
        String[] locations = {"CAN", "US", "MX", "UK", "FRA", "BRA", "AUS", "IN"};
        for(int i = 0; i < names.length; i++){
            for(int j = 0; j < messages.length; j++){
                for(int k = 0; k < locations.length; k++){
                    BigInteger randomId = new BigInteger(String.valueOf((int)(40000000*Math.random())));
                    texts.add(new Text(randomId, messages[j], names[i], "10/5/2022", "13:00", locations[k]));
                }
            }
        }
        return texts;
    }
}
