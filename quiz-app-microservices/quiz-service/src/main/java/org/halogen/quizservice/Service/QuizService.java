package org.halogen.quizservice.Service;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.halogen.quizservice.Feign.QuizInterface;
import org.halogen.quizservice.Model.QuestionWrapper;
import org.halogen.quizservice.Model.Quiz;
import org.halogen.quizservice.Model.Response;
import org.halogen.quizservice.Repository.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {
    @Autowired
    private QuizRepo quizRepo;

    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<Quiz> createQuiz(String category, int numQues, String title) {
        try {
            List<Integer> questions = quizInterface.generateQuestions(numQues, category).getBody();

            Quiz quiz = new Quiz();
            quiz.setCategory(category);
            quiz.setNumQues(numQues);
            quiz.setTitle(title);
            quiz.setQuestions(questions);

            quizRepo.save(quiz);

            return new ResponseEntity<>(quiz, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(new Quiz(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
        try {
            Quiz quiz = quizRepo.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Quiz " + id + " not found"));

            List<Integer> questionId = quiz.getQuestions();

            return quizInterface.getQuestionById(questionId);
        }
        catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Integer> calcResult(int id, List<Response> response) {
        try {
            Quiz quiz = quizRepo.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Quiz " + id + " not found"));

            return quizInterface.calcResult(response);
        }
        catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
