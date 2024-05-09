package com.questionservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.questionservice.repository.QuestionRepository;
import com.questionservice.wrapper.QuestionWrapper;
import com.questionservice.model.Question;
import com.questionservice.model.Response;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	
	public ResponseEntity< List<Question>> getAllQuestion() {
		try {
		return new ResponseEntity<List<Question>>(questionRepository.findAll(),HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Question>>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
		
	}

	public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
		try {
		return new ResponseEntity<List<Question>>( questionRepository.findByCategory(category),HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Question>>( new ArrayList<>(),HttpStatus.OK);
		
	}

	public ResponseEntity<String> addQuestion(Question question) {
		questionRepository.save(question);
		return  new ResponseEntity<String>("Suceess",HttpStatus.CREATED);
	}

	public ResponseEntity<List<Integer>> getQuestionForQuiz(String categoryName, Integer numQuestions) {
		List<Integer> questions=questionRepository.findRandomQuestionsByCategory(categoryName,numQuestions);
		
		return new ResponseEntity<List<Integer>>(questions,HttpStatus.OK);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuestionFromID(List<Integer> questionIds) {
		
		List<QuestionWrapper> wrappers=new ArrayList<>();
		List<Question> questions=new ArrayList<>();
		
		for(Integer id: questionIds) {
			questions.add(questionRepository.findById(id).get());
		}
		
		for(Question question: questions)
		{
			QuestionWrapper questionWrapper=new QuestionWrapper();
			questionWrapper.setId(question.getId());
			questionWrapper.setQuestionTitle(question.getQuestionTitle());
			questionWrapper.setOptional1(question.getOptional1());
			questionWrapper.setOptional2(question.getOptional2());
			questionWrapper.setOptional3(question.getOptional3());
			questionWrapper.setOptional4(question.getOptional4());
			wrappers.add(questionWrapper);
		}
		
		return new ResponseEntity<List<QuestionWrapper>>(wrappers,HttpStatus.OK);
	}

	public ResponseEntity<Integer> getScore(List<Response> responses) {
		
		int right=0;
		
		for(Response response : responses ) {
			Question question=questionRepository.findById(response.getId()).get();
			if(response.getResponse().equals(question.getRightAnswer()))
			
				right++;
		}
		return new ResponseEntity<Integer>(right,HttpStatus.OK);
	}



}
