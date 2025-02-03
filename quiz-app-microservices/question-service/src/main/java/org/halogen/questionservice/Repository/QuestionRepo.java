package org.halogen.questionservice.Repository;

import org.halogen.questionservice.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {
    List<Question> findByCategory(String category);

    @Query(value = "select q.id from question q where q.category = :category order by random() limit :numQues", nativeQuery = true)
    List<Integer> findRandomQuestionsByCategory(String category, int numQues);
}
