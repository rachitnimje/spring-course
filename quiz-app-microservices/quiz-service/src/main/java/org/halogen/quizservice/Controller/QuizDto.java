package org.halogen.quizservice.Controller;

public class QuizDto {
    private String category;
    private int numQues;
    private String title;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getNumQues() {
        return numQues;
    }

    public void setNumQues(int numQues) {
        this.numQues = numQues;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
