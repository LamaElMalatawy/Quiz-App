package com.lamaelmalatawy.quizservice.controller;


import com.lamaelmalatawy.quizservice.entity.QuizDto;
import com.lamaelmalatawy.quizservice.entity.QuestionWrapper;
import com.lamaelmalatawy.quizservice.entity.Response;
import com.lamaelmalatawy.quizservice.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;
    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){
        return quizService.createQuiz(quizDto.getCategoryName(),quizDto.getNumQuestions(),quizDto.getTitle());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuesions(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> submit(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateResults(id,responses);
    }

}
