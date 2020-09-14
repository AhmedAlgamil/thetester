package com.algamil.thetester.data.models;

public class ChooseAns {

    private String question;
    private String correct_ans;
    private String worng1_ans;
    private String worng2_ans;
    private String worng3_ans;

    public ChooseAns(String question, String correct_ans, String worng1_ans, String worng2_ans, String worng3_ans) {
        this.question = question;
        this.correct_ans = correct_ans;
        this.worng1_ans = worng1_ans;
        this.worng2_ans = worng2_ans;
        this.worng3_ans = worng3_ans;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrect_ans() {
        return correct_ans;
    }

    public void setCorrect_ans(String correct_ans) {
        this.correct_ans = correct_ans;
    }

    public String getWorng1_ans() {
        return worng1_ans;
    }

    public void setWorng1_ans(String worng1_ans) {
        this.worng1_ans = worng1_ans;
    }

    public String getWorng2_ans() {
        return worng2_ans;
    }

    public void setWorng2_ans(String worng2_ans) {
        this.worng2_ans = worng2_ans;
    }

    public String getWorng3_ans() {
        return worng3_ans;
    }

    public void setWorng3_ans(String worng3_ans) {
        this.worng3_ans = worng3_ans;
    }
}
