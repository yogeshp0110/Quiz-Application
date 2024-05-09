package com.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.model.Quiz;

@Repository
public interface QuizRespository extends JpaRepository<Quiz, Integer>{

	
}
