package org.schoolbaltimoreEL;

public class Question {


    //instance variables
    private String questionPrompt;

    private boolean correctAnswer;

    //constructor
    public Question() {
        questionPrompt = "unknown";
        correctAnswer = false;
    }

    //pass-through constructor
    public Question(String newquestionPrompt, boolean newcorrectAnswer) {
        questionPrompt = newquestionPrompt;
        correctAnswer = newcorrectAnswer;
    }

    //methods
    public String getQuestionPrompt() {
        return questionPrompt;
    }

    public boolean getCorrectAnswer() {
        return correctAnswer;
    }

    //setter methods
    public void setQuestionPrompt(String newquestionPrompt) {
        questionPrompt = newquestionPrompt;
    }

    public void setCorrectAnswer(boolean newcorrectAnswer) {
            correctAnswer = newcorrectAnswer;
    }

    public String toString() {
        return questionPrompt + " ? " + correctAnswer;
    }
}