package App.Controller;

import App.Model.Text;
import App.Service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TextController {
    TextService textService;
    @Autowired
    public TextController(TextService textService){
        this.textService = textService;
    }
    @GetMapping
    public List<Text> getAllTexts(){
        return textService.getAllText();
    }
    @GetMapping("sender/{name}")
    public List<Text> getAllTextsBySender(@PathVariable String name){
        return textService.getTextsBySender(name);
    }
    @PostMapping
    public Text addText(@RequestBody Text text){
        return textService.addText(text);
    }
}
