package com.lamaelmalatawy.questionservice.controller;


import com.lamaelmalatawy.questionservice.entity.Question;
import com.lamaelmalatawy.questionservice.entity.QuestionWrapper;
import com.lamaelmalatawy.questionservice.entity.Response;
import com.lamaelmalatawy.questionservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @GetMapping("/all-questions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("/category/{category}")
    public  ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("/add")
    public  ResponseEntity<Question> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @GetMapping("/generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String category,@RequestParam int numQuestions){
        return questionService.getQuestionsForQuiz(category,numQuestions);
    }

    @PostMapping("/get-questions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds ){
        return questionService.getQuestionFromId(questionIds);
    }

    @PostMapping("/get-score")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
        return questionService.getScore(responses);
    }
}
