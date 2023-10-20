package Gapps.quiz.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Gapps.quiz.DTO.QuestionDto;

import Gapps.quiz.mappers.QuestionMapper;
import Gapps.quiz.mappers.QuestionModelToDtoMapper;
import Gapps.quiz.models.QuestionModel;
import Gapps.quiz.repositories.QuestionRepo;

@Service
public class QuestionService {

    private final QuestionRepo questionRepo;
    private final QuestionMapper questionMapper;
    private final QuestionModelToDtoMapper questionModelToDtoMapper;

    @Autowired
    public QuestionService(QuestionRepo questionRepo,
            QuestionMapper questionMapper,
            QuestionModelToDtoMapper questionModelToDtoMapper) {
        this.questionRepo = questionRepo;
        this.questionMapper = questionMapper;
        this.questionModelToDtoMapper = questionModelToDtoMapper;
    }

    public Optional<QuestionDto> getQuestion(Long id) {
        return questionRepo.findById(id)
                .map(questionModelToDtoMapper::questionModelToQuestionDto);
    }

    public QuestionModel saveQuestion(QuestionDto questionDto) {
        QuestionModel model = questionMapper.questionDtoToQuestionModel(questionDto);
        QuestionModel savedModel = questionRepo.save(model);

        return savedModel;
    }

}
