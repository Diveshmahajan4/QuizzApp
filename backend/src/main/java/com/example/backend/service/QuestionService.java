package com.example.backend.service;

import com.example.backend.Questions;
import com.example.backend.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public List<Questions> getAllQuestions() {
        return questionDao.findAll();
    }

    public List<Questions> getAllQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public String addQuestion(Questions question) {
    }
}
