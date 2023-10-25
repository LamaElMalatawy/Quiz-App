package com.lamaelmalatawy.quizservice.dao;


import com.lamaelmalatawy.quizservice.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizDao extends JpaRepository<Quiz,Integer> {
}
