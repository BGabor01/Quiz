package Gapps.quiz.DTO;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class AnswerDto {

    @NotBlank(message = "Answer text cannot be blank")
    private String text;
    private boolean isCorrect;
}
