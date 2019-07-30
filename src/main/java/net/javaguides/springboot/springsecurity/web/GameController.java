package net.javaguides.springboot.springsecurity.web;

import net.javaguides.springboot.springsecurity.model.Word;
import net.javaguides.springboot.springsecurity.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/game")
public class GameController {

    @Autowired
    private WordService wordService;

    @GetMapping
    public String showGame(@RequestParam String lang, Model model) {
        Word word = wordService.getNewWordFromDictionary(lang);
        model.addAttribute("word", word);
        return "game";
    }
}
