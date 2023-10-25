package com.lamaelmalatawy.questionservice.service;


import com.lamaelmalatawy.questionservice.dao.QuestionDao;
import com.lamaelmalatawy.questionservice.entity.Question;
import com.lamaelmalatawy.questionservice.entity.QuestionWrapper;
import com.lamaelmalatawy.questionservice.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<List<Question>> getAllQuestions() {
        try{
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public  ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try{
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public  ResponseEntity<Question> addQuestion(Question question) {
        return new ResponseEntity<>(questionDao.save(question),HttpStatus.CREATED);
    }

    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String category, int numQuestions) {
        List<Integer> questions = questionDao.findRandomQuestionsByCategory(category,numQuestions);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionFromId(List<Integer> questionIds) {
        List<QuestionWrapper> wrappers = new ArrayList<>();
        Question question;
        QuestionWrapper questionWrapper;
        for(Integer id: questionIds){
            questionWrapper = new QuestionWrapper();
            question = questionDao.findById(id).get();
            questionWrapper.setId(question.getId());
            questionWrapper.setQuestionTitle(question.getQuestionTitle());
            questionWrapper.setDifficultyLevel(question.getDifficultyLevel());
            questionWrapper.setOption1(question.getOption1());
            questionWrapper.setOption2(question.getOption2());
            questionWrapper.setOption3(question.getOption3());
            questionWrapper.setOption4(question.getOption4());
            wrappers.add(questionWrapper);
        }
        return new ResponseEntity<>(wrappers,HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<Response> responses) {
        Question question;
        int right = 0;
        for (Response response: responses){
            question = questionDao.findById(response.getId()).get();
            if(response.getResponse().equals(question.getRightAnswer()))
                ++right;
        }
        return new ResponseEntity<>(right, HttpStatus.OK);

    }
}
