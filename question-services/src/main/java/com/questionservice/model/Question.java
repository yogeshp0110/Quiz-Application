package com.questionservice.model;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Transactional
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String questionTitle;
	private String optional1;
	private String optional2;
	private String optional3;
	private String optional4;
	private String rightAnswer;
	private String difficultylevel;
	private String category;
	
	


	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Question(Integer id, String questionTitle, String optional1, String optional2, String optional3,
			String optional4, String rightAnswer, String difficultylevel) {
		super();
		this.id = id;
		this.questionTitle = questionTitle;
		this.optional1 = optional1;
		this.optional2 = optional2;
		this.optional3 = optional3;
		this.optional4 = optional4;
		this.rightAnswer = rightAnswer;
		this.difficultylevel = difficultylevel;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	public String getOptional1() {
		return optional1;
	}
	public void setOptional1(String optional1) {
		this.optional1 = optional1;
	}
	public String getOptional2() {
		return optional2;
	}
	public void setOptional2(String optional2) {
		this.optional2 = optional2;
	}
	public String getOptional3() {
		return optional3;
	}
	public void setOptional3(String optional3) {
		this.optional3 = optional3;
	}
	public String getOptional4() {
		return optional4;
	}
	public void setOptional4(String optional4) {
		this.optional4 = optional4;
	}
	public String getRightAnswer() {
		return rightAnswer;
	}
	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}
	public String getDifficultylevel() {
		return difficultylevel;
	}
	public void setDifficultylevel(String difficultylevel) {
		this.difficultylevel = difficultylevel;
	}
	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public Question(Integer id, String questionTitle, String optional1, String optional2, String optional3,
			String optional4, String rightAnswer, String difficultylevel, String category) {
		super();
		this.id = id;
		this.questionTitle = questionTitle;
		this.optional1 = optional1;
		this.optional2 = optional2;
		this.optional3 = optional3;
		this.optional4 = optional4;
		this.rightAnswer = rightAnswer;
		this.difficultylevel = difficultylevel;
		this.category = category;
		
		
	}

	
}
