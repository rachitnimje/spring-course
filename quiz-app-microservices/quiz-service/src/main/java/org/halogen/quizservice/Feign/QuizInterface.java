package org.halogen.quizservice.Feign;

import org.halogen.quizservice.Model.QuestionWrapper;
import org.halogen.quizservice.Model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {

    @GetMapping("question/generate")
    public ResponseEntity<List<Integer>> generateQuestions(@RequestParam int numQues, @RequestParam String category);

    @PostMapping("question/get")
    public ResponseEntity<List<QuestionWrapper>> getQuestionById(@RequestBody List<Integer> questionId);

    @PostMapping("question/result")
    public ResponseEntity<Integer> calcResult(@RequestBody List<Response> response);
}
