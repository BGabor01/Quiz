package Gapps.quiz.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class QuestionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;

    private Boolean isCorrect;

    @OneToMany(mappedBy = "questionModel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AnswerModel> answers = new ArrayList<>();

}
