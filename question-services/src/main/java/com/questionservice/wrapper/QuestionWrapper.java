package com.questionservice.wrapper;

public class QuestionWrapper {

	private Integer id;
	private String questionTitle;
	private String optional1;
	private String optional2;
	private String optional3;
	private String optional4;
	
	
	
	public QuestionWrapper(Integer id, String questionTitle, String optional1, String optional2, String optional3,
			String optional4) {
		super();
		this.id = id;
		this.questionTitle = questionTitle;
		this.optional1 = optional1;
		this.optional2 = optional2;
		this.optional3 = optional3;
		this.optional4 = optional4;
	}
	
	public QuestionWrapper() {
		super();
		// TODO Auto-generated constructor stub
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
}
