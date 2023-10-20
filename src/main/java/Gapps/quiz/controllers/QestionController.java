package Gapps.quiz.controllers;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Gapps.quiz.DTO.QuestionDto;
import Gapps.quiz.models.QuestionModel;
import Gapps.quiz.services.QuestionService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/question")
public class QestionController {

    private final QuestionService questionService;

    public QestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getQuestion(@PathVariable Long id) {
        Optional<QuestionDto> question = questionService.getQuestion(id);

        return question.<ResponseEntity<Object>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).body("Not found"));
    }

    @PostMapping
    public QuestionModel saveQuestion(@Valid @RequestBody QuestionDto questionDto) {
        return questionService.saveQuestion(questionDto);
    }

}
