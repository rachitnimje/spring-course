package org.halogen.quizapp.Repository;

import org.halogen.quizapp.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {
    List<Question> findByCategory(String category);

    @Query(value = "select * from question q where q.category = :category order by random() limit :numQues", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numQues);
}
