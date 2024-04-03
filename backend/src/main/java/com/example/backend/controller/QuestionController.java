package com.example.backend.controller;

import com.example.backend.Questions;
import com.example.backend.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    // READ operations
    @RequestMapping("allQuestions")
    public List<Questions> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @RequestMapping("/category/{category}")
    public List<Questions> getAllQuestionsByCategory(@PathVariable String category){
        return questionService.getAllQuestionsByCategory(category);
    }

    // ADD Operations
    public String addQuestion(@RequestBody Questions question){
        return questionService.addQuestion(question);
    }
}
