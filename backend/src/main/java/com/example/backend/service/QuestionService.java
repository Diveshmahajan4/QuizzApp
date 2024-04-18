package com.example.backend.service;

import com.example.backend.model.Questions;
import com.example.backend.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Questions>> getAllQuestions() {
        try{
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Questions>> getAllQuestionsByCategory(String category) {
        try{
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Questions question) {
        try {
            questionDao.save(question);
            return new ResponseEntity<>("Success!", HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Something went wrong!!" , HttpStatus.BAD_GATEWAY);
    }

    public ResponseEntity<String> deleteQuestion(int id) {
        try{
            questionDao.deleteById(id);
            return new ResponseEntity<>( "Question of " + id + " id is deleted", HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>( "Something went Wrong!!", HttpStatus.BAD_GATEWAY);
    }

//    public ResponseEntity<String> updateQuestion(Integer id) {
//        try{
//            // Update Question Logic
//            Questions questions =
//            questionDao.updateQuestionById(id);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}
