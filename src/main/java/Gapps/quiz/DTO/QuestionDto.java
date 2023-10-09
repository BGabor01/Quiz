package Gapps.quiz.DTO;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class QuestionDto {

    @NotBlank(message = "Question cannot be blank")
    @Size(min = 5, max = 255, message = "Question must be between 5 and 500 characters")
    private String question;

    @NotEmpty(message = "Answers cannot be empty")
    @Size(min = 4, max = 4, message = "Must provide 4 answers")
    @Valid
    private List<AnswerDto> answers;

}
