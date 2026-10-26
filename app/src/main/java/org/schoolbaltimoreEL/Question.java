package org.schoolbaltimoreEL;

public class Question {


    //instance variables
    private String questionPrompt;
    private String hintLink;
    private boolean correctAnswer;

    //constructor
    public Question() {
        questionPrompt = "unknown";
        correctAnswer = false;
        hintLink = "unknow";
    }

    // pass-through constructor
    public Question(String newquestionPrompt,
                    boolean newcorrectAnswer,
                    String newHintLink) {

        questionPrompt = newquestionPrompt;
        correctAnswer = newcorrectAnswer;
        hintLink = newHintLink;

    }

    // getter methods
    public String getQuestionPrompt() {
        return questionPrompt;
    }

    public boolean getCorrectAnswer() {
        return correctAnswer;
    }

    public String getHintLink() {
        return hintLink;
    }

    // setter methods
    public void setQuestionPrompt(String newquestionPrompt) {
        questionPrompt = newquestionPrompt;
    }

    public void setCorrectAnswer(boolean newcorrectAnswer) {
        correctAnswer = newcorrectAnswer;
    }

    public void setHintLink(String newHintLink) {
        hintLink = newHintLink;
    }

    public String toString() {
        return questionPrompt + " ? " + correctAnswer + " " + hintLink;
    }
}