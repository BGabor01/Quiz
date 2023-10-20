package Gapps.quiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import Gapps.quiz.models.QuestionModel;

public interface QuestionRepo extends JpaRepository<QuestionModel, Long> {
    
}
