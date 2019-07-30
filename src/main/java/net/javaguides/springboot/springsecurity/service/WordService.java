package net.javaguides.springboot.springsecurity.service;

import net.javaguides.springboot.springsecurity.model.Dictionary;
import net.javaguides.springboot.springsecurity.model.User;
import net.javaguides.springboot.springsecurity.model.Word;
import net.javaguides.springboot.springsecurity.repository.DictionaryRepository;
import net.javaguides.springboot.springsecurity.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class WordService {

    @Autowired
    private DictionaryRepository dictionaryRepository;

    @Autowired
    private WordRepository wordRepository;

    @Autowired
    private UserService userService;

    private List<String> listSeenWords(String language) {
        User activeUser = userService.getUser();
        List<Word> seenWords = wordRepository.getAllByLanguageAndUser(language, activeUser);
        List<String> seenWordTexts = new ArrayList<>();
        for (Word w: seenWords) {
            seenWordTexts.add(w.getText());
        }
        // if no words have been seen then an empty string is added so the MySQL query does not break
        if (seenWords.size() == 0) {
            seenWordTexts.add("");
        }
        return seenWordTexts;
    }

//    public Word getSeenWord(String language) {
//        User activeUser = userService.getUser();
//        List<Word> seenWords = wordRepository.getAllByLanguageAndUser(language, activeUser);
//    }

    public Word getNewWordFromDictionary(String language) {
        List<Dictionary> dictionaries = dictionaryRepository.findTop1ByLanguageAndTextNotIn(language, listSeenWords(language));
        Dictionary newWord = dictionaries.get(0);
        Word word = new Word();
        word.setLanguage(newWord.getLanguage());
        word.setText(newWord.getText());
        word.setTranslation(newWord.getTranslation());
        word.setUser(userService.getUser());
//        wordRepository.save(word); // needs to be uncommented later
        return word;
    }
}
