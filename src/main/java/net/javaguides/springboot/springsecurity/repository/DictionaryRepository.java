package net.javaguides.springboot.springsecurity.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.springsecurity.model.Dictionary;

import java.util.List;

@Repository
public interface DictionaryRepository extends JpaRepository<Dictionary, Long> {
    List<Dictionary> findTop1ByLanguageAndTextNotIn(String language, List<String> texts);
}
