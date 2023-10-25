package com.lamaelmalatawy.quizservice.service;


import com.lamaelmalatawy.quizservice.dao.QuizDao;
import com.lamaelmalatawy.quizservice.entity.*;
import com.lamaelmalatawy.quizservice.feign.QuizInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService{

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String category, int numQ,String title){
        List<Integer> questionsIds = quizInterface.getQuestionsForQuiz(category,numQ).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionsIds(questionsIds);

        quizDao.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Integer> questionsIds = quiz.get().getQuestionsIds();
        ResponseEntity<List<QuestionWrapper>> questionsForUser = quizInterface.getQuestionsFromId(questionsIds);
        return questionsForUser;
    }

    public ResponseEntity<Integer> calculateResults(Integer id, List<Response> responses) {
//        Quiz quiz = quizDao.findById(id).get();
//        List<Question> questions = quiz.getQuestions();
//
          int right = 0;
//        int i = 0;
//        for (Response response: responses){
//            if(response.getResponse().equals(questions.get(i).getRightAnswer()))
//                ++right;
//
//            ++i;
//        }
        return new ResponseEntity<>(right, HttpStatus.OK);
//        return null;
    }
}
