package org.halogen.quizapp.Service;

import org.halogen.quizapp.Model.Question;
import org.halogen.quizapp.Model.QuestionWrapper;
import org.halogen.quizapp.Model.Quiz;
import org.halogen.quizapp.Model.Response;
import org.halogen.quizapp.Repository.QuestionRepo;
import org.halogen.quizapp.Repository.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
 
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizService {
    @Autowired
    private QuizRepo quizRepo;
    @Autowired
    private QuestionRepo questionRepo;

    public ResponseEntity<Quiz> createQuiz(String category, int numQues, String title) {
        try {
            List<Question> questions = questionRepo.findRandomQuestionsByCategory(category, numQues);

            Quiz quiz = new Quiz();
            quiz.setTitle(title);
            quiz.setCategory(category);
            quiz.setQuestions(questions);
            quiz.setNumQues(numQues);

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

            List<QuestionWrapper> questionWrappers = quiz.getQuestions()
                    .stream()
                    .map(q -> new QuestionWrapper(
                            q.getId(),
                            q.getQuestionTitle(),
                            q.getOption1(),
                            q.getOption2(),
                            q.getOption3(),
                            q.getOption4()))
                    .collect(Collectors.toList());

            return new ResponseEntity<>(questionWrappers, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Integer> calcResult(int id, List<Response> response) {
        try {
            Quiz quiz = quizRepo.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Quiz " + id + " not found"));

            List<Question> questions = quiz.getQuestions();
            int correct = 0;
            int questionsCount = 0;

            for(Response r : response){
                if(r.getResponse().equals(questions.get(questionsCount).getRightAnswer())){
                    correct++;
                }
                questionsCount++;
            }

            return new ResponseEntity<>(correct, HttpStatus.OK);
        }
        catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
