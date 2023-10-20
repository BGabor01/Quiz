package Gapps.quiz.mappers;

import org.mapstruct.*;

import Gapps.quiz.DTO.AnswerDto;
import Gapps.quiz.DTO.QuestionDto;
import Gapps.quiz.models.AnswerModel;
import Gapps.quiz.models.QuestionModel;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "answers", qualifiedByName = "answerDtoListToAnswerModelList")
    QuestionModel questionDtoToQuestionModel(QuestionDto questionDto);

    @IterableMapping(qualifiedByName = "answerDtoToAnswerModel")
    @Named("answerDtoListToAnswerModelList")
    List<AnswerModel> answerDtoListToAnswerModelList(List<AnswerDto> answerDtos);

    @Mapping(target = "questionModel", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Named("answerDtoToAnswerModel")
    AnswerModel answerDtoToAnswerModel(AnswerDto answerDto);

    @AfterMapping
    default void setQuestionModel(@MappingTarget QuestionModel questionModel) {
        Optional.ofNullable(questionModel.getAnswers())
                .ifPresent(it -> it.forEach(answer -> answer.setQuestionModel(questionModel)));
    }
}
