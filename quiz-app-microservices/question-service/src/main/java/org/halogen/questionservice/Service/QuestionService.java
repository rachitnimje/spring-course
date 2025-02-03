package org.halogen.questionservice.Service;

import org.halogen.questionservice.Model.Question;
import org.halogen.questionservice.Model.QuestionWrapper;
import org.halogen.questionservice.Model.Response;
import org.halogen.questionservice.Repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepo questionsRepo;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionsRepo.findAll(), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionsRepo.findByCategory(category), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Question> addQuestion(Question question) {
        try {
            return new ResponseEntity<>(questionsRepo.save(question), HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(new Question(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> deleteQuestion(Question question) {
        try {
            questionsRepo.deleteById(question.getId());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<Integer>> generateQuestions(int numQues, String category) {
        List<Integer> questions = questionsRepo.findRandomQuestionsByCategory(category, numQues);

        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionById(List<Integer> questionId) {
        try {
            List<QuestionWrapper> questionWrappers = new ArrayList<>();
            List<Question> questions = questionsRepo.findAllById(questionId);

            for(Question q : questions) {
                QuestionWrapper qw = new QuestionWrapper(
                        q.getId(),
                        q.getQuestionTitle(),
                        q.getOption1(),
                        q.getOption2(),
                        q.getOption3(),
                        q.getOption4()
                );
                questionWrappers.add(qw);
            }

            return new ResponseEntity<>(questionWrappers, HttpStatus.OK);
        }
        catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<Integer> calcResult(List<Response> response) {
        try {
            int correctAnswers = 0;
            for (Response r : response) {
                Question question = questionsRepo.findById(r.getId()).orElseThrow(() -> new ResourceNotFoundException("Question not found"));

                if(r.getResponse().equals(question.getRightAnswer())) {
                    correctAnswers++;
                }
            }
            return new ResponseEntity<>(correctAnswers, HttpStatus.OK);
        }
        catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
