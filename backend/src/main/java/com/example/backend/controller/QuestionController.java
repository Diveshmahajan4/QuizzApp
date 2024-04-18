package com.example.backend.controller;

import com.example.backend.model.Questions;
import com.example.backend.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    // READ operations
    @RequestMapping("allQuestions")
    public ResponseEntity<List<Questions>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @RequestMapping("/category/{category}")
    public ResponseEntity<List<Questions>> getAllQuestionsByCategory(@PathVariable String category){
        return questionService.getAllQuestionsByCategory(category);
    }

    // ADD Operations
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Questions question){
        return questionService.addQuestion(question);
    }

    //UPDATE operation
//    public ResponseEntity<String> updateQuestion(@PathVariable Integer id){
//        return questionService.updateQuestion(id);
//    }

    // DELETE Operation
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Integer id){
        return questionService.deleteQuestion(id);
    }
}
