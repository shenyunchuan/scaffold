package com.example.scaffold.bean;

public class QuestionAnswerModel {
    private String question;
    private String answer;
    private int arrow;



    public QuestionAnswerModel(String question, String answer,int arrow) {
        this.question = question;
        this.answer = answer;
        this.arrow = arrow;
    }

    public String getQuestion() {
        return question;
    }

    public int getArrow() {
        return arrow;
    }

    public void setArrow(int arrow) {
        this.arrow = arrow;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
