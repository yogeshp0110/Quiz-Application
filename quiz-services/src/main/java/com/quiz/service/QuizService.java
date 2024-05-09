package com.quiz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quiz.dto.quizDto;
import com.quiz.feign.QuizInterface;

import com.quiz.model.Quiz;
import com.quiz.model.Response;
import com.quiz.repository.QuizRespository;
import com.quiz.wrapper.QuestionWrapper;

@Service
public class QuizService {

	@Autowired
	private QuizRespository quizRepository;
	
	@Autowired
	QuizInterface quizInterface;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
	   
		List<Integer> question =quizInterface.getQuestionForQuiz(category, numQ).getBody();
		Quiz quiz=new Quiz();
		quiz.setTitle(title);
		quiz.setQuestionsIds(question);
		quizRepository.save(quiz);
		
		return new ResponseEntity<String>("Success",HttpStatus.CREATED);
		
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		Quiz quiz=quizRepository.findById(id).get();
		List<Integer> questionsIds=quiz.getQuestionsIds();
		ResponseEntity<List<QuestionWrapper>> questions= quizInterface.getQuestionFromID(questionsIds);
		return questions;
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		ResponseEntity<Integer> score	=quizInterface.getScore(responses);
		return score;
	}
}
