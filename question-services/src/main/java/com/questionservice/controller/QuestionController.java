package com.questionservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.questionservice.model.Question;
import com.questionservice.model.Response;
import com.questionservice.service.QuestionService;
import com.questionservice.wrapper.QuestionWrapper;


@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	Environment environment;
	
	
	@GetMapping("allQuestion")
	public ResponseEntity<List<Question>> getAllQuestion()
	{
		return questionService.getAllQuestion();
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category)
	{
		return questionService.getQuestionByCategory(category);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addQuestion(@RequestBody Question question)
	{
		return questionService.addQuestion(question);
	}
	
	@GetMapping("generate")
	public ResponseEntity<List<Integer>> getQuestionForQuiz
	                 (@RequestParam String categoryName,@RequestParam Integer numQuestions)
	  {
		return questionService.getQuestionForQuiz(categoryName,numQuestions);	  
	  }
	
	@PostMapping("getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionFromID(@RequestBody List<Integer> questionIds){
		System.out.println(environment.getProperty("local.server.port"));
		return questionService.getQuestionFromID(questionIds);
	}
	  
     @PostMapping("getScore")
     public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses)
     {
    	 return questionService.getScore(responses);
     }
}
