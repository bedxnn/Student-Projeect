package StudentAiProject.work;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/flashcards")
public class FlashCardController {
    private final flashCardsService flashCardsService;

    @Autowired
    public FlashCardController(flashCardsService flashCardsService){
        this.flashCardsService = flashCardsService;

    }
    @GetMapping
    public List<Flashcards> getAll(){
        return flashCardsService.getAllFlashcards();
    }
       @GetMapping("/{id}")
    public Flashcards getOne(@PathVariable long id){
        return flashCardsService.getFlashcardById(id)
                .orElseThrow(() -> new RuntimeException("Flashcard not found"));
       }
@PostMapping
    public ResponseEntity<Flashcards> create(@RequestBody Flashcards body){
        Flashcards saved = flashCardsService.saveFlashcard(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
}
@PutMapping("/{id}")
    public ResponseEntity<Flashcards> update (@PathVariable Long id, @RequestBody Flashcards body){
        Flashcards updated = flashCardsService.updateFlashCard(id, body);
        return ResponseEntity.ok(updated);
}
@DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        flashCardsService.deleteFlashcard(id);
        return ResponseEntity.noContent().build();
}
@GetMapping("/by-tag")
public List<Flashcards> byTag(@RequestParam String tag){
        return flashCardsService.findByTag(tag);
}
@GetMapping("/created-after")
    public List <Flashcards> createdAfter(
        @RequestParam LocalDateTime after){
        return flashCardsService.findByCreatedAtAfter(after);
}


}
