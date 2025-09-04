package StudentAiProject.work;

import jakarta.persistence.*;

import java.util.List;

import java.time.LocalDateTime;


@Entity
@Table(name ="Flashcards")
public class Flashcards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String filename;

    private String summaries;

    @Column(columnDefinition = "text")
    private String notes;

    private String content;

    private LocalDateTime createdAt;

    private String description;
@ElementCollection
    private List <String>tags;

    private LocalDateTime updatedAt;

    public Flashcards(){

    }
    public Flashcards(String filename, String description) {
        this.filename = filename;
        this.description = description;
        this.createdAt = LocalDateTime.now(); // default to now
    }


    public Flashcards(String filename, String content, LocalDateTime createdAt, String description, List <String> tags, LocalDateTime updatedAt){
        this.filename = filename;
        this.content = content;
        this.createdAt = createdAt;
        this.description= description;
        this.tags = tags;
        this.updatedAt = updatedAt;

    }
    public String getFilename(){
        return filename;
    }
    public void setFilename(String filename){
    this.filename=filename;
    }

    public String getNotes(){
        return notes;
    }
    public void setNotes(String notes){
        this.notes = notes;
    }
    public String getSummaries(){
        return summaries;
    }
    public void setSummaries(String summaries){
        this.summaries = summaries;
    }

    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
}

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id=id;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt = createdAt;
    }
    public  List  <String> getTags(){
        return tags;
    }
    public void setTags(List <String> tags){
        this.tags= tags;
    }
    public LocalDateTime getUpdatedAt(){
        return updatedAt;
    }
    public void setUpdatedAt( LocalDateTime updatedAt){
        this.updatedAt = updatedAt;
    }
}



