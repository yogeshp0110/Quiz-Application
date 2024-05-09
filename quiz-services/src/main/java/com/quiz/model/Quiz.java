package com.quiz.model;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;


@Entity
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(
//			     name = "quiz_question",
//			     joinColumns =  @JoinColumn(name = "quiz_id"),
//			     inverseJoinColumns = @JoinColumn(name="question_id")
//			
//			)
	
	//@ManyToMany(cascade = CascadeType.ALL)
	@ElementCollection
	private List<Integer> questionsIds;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Integer> getQuestionsIds() {
		return questionsIds;
	}
	public void setQuestionsIds(List<Integer> questionsIds) {
		this.questionsIds = questionsIds;
	}
	
	
	
}
