package org.halogen.questionservice.Controller;

import org.halogen.questionservice.Model.Question;
import org.halogen.questionservice.Model.QuestionWrapper;
import org.halogen.questionservice.Model.Response;
import org.halogen.questionservice.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("/add")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteQuestion(@RequestBody Question question){
        return questionService.deleteQuestion(question);
    }

    // TODO
    // get random questions for the quiz    (DONE)
    // getQuestion(int id) based on id      (DONE)
    // getResult()                          (DONE)

    @GetMapping("/generate")
    public ResponseEntity<List<Integer>> generateQuestions(@RequestParam int numQues, @RequestParam String category){
        return questionService.generateQuestions(numQues, category);
    }

    @PostMapping("/get")
    public ResponseEntity<List<QuestionWrapper>> getQuestionById(@RequestBody List<Integer> questionId){
        return questionService.getQuestionById(questionId);
    }

    @PostMapping("result")
    public ResponseEntity<Integer> calcResult(@RequestBody List<Response> response){
        return questionService.calcResult(response);
    }
}
