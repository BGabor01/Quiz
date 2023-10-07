package Gapps.quiz.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class QuestionModel {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String question;

    private String answer;

}
