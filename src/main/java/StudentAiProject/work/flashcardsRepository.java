package StudentAiProject.work;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface flashcardsRepository extends JpaRepository<Flashcards, Long> {

 List<Flashcards> findByDescription(String description);

 List <Flashcards> findByTagsContaining(String tags);

 List<Flashcards> findByCreatedAtAfter(LocalDateTime date);

}
