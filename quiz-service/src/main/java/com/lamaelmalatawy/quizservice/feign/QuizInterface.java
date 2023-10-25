package com.lamaelmalatawy.quizservice.feign;


import com.lamaelmalatawy.quizservice.entity.QuestionWrapper;
import com.lamaelmalatawy.quizservice.entity.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
    @GetMapping("/questions/generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz
            (@RequestParam String category, @RequestParam int numQuestions);

    @PostMapping("/questions/get-questions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId
            (@RequestBody List<Integer> questionIds);

    @PostMapping("/questions/get-score")
    public ResponseEntity<Integer> getScore
            (@RequestBody List<Response> responses);
}
