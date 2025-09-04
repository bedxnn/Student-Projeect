package StudentAiProject.work;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class flashCardsService {
    private final flashcardsRepository flashcardsRepository;

    @Autowired
    public flashCardsService(flashcardsRepository flashcardsRepository) {
        this.flashcardsRepository = flashcardsRepository;
    }

    public Flashcards saveFlashcard(Flashcards flashcard) {
        return flashcardsRepository.save(flashcard);
    }
    public List<Flashcards> getAllFlashcards(){
        return flashcardsRepository.findAll();
    }
    public List<Flashcards> findByTag(String tag) {
        return flashcardsRepository.findByTagsContaining(tag);
    }
    public Optional<Flashcards> getFlashcardById(Long id){
        return flashcardsRepository.findById(id);
    }
    public void deleteFlashcard(Long id){
       flashcardsRepository.deleteById( id);
    }
    public Flashcards updateFlashCard(Long id, Flashcards newData){
        return flashcardsRepository.findById(id).map(f ->{
            f.setFilename(newData.getFilename());
            f.setDescription(newData.getDescription());
            f.setContent(newData.getContent());
            f.setTags(newData.getTags());
            f.setCreatedAt(newData.getCreatedAt());
            f.setNotes(newData.getNotes());
            f.setSummaries(newData.getSummaries());
            return flashcardsRepository.save(f);

        }).orElseThrow(() -> new RuntimeException("Flashcard not found"));
    }
    public List <Flashcards> findByDescription(String description){
        return flashcardsRepository.findByDescription(description);
    }
    public List <Flashcards> findByCreatedAtAfter(LocalDateTime date){
        return flashcardsRepository.findByCreatedAtAfter(date);
    }



}
