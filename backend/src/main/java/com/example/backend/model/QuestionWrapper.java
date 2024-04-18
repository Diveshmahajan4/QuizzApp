package com.example.backend.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class QuestionWrapper {
    public QuestionWrapper(Integer id, String questionsTitle, String option1, String option2, String option3, String option4) {
        this.id = id;
        this.questionsTitle = questionsTitle;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }

    private Integer id;
    private String questionsTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
}
