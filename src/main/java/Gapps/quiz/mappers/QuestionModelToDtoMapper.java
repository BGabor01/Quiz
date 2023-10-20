package Gapps.quiz.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import Gapps.quiz.DTO.QuestionDto;
import Gapps.quiz.models.QuestionModel;

@Mapper(componentModel = "spring")
public interface QuestionModelToDtoMapper {

    @Mapping(target = "question")
    @Mapping(target = "answers")
    QuestionDto questionModelToQuestionDto(QuestionModel savedModel);

}