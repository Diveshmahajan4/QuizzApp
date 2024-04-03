package com.example.backend.dao;

import com.example.backend.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Questions, Integer> {

    // JPA will automatically return a list according to category, you don't have to write
    // separate sql queries.
    List<Questions> findByCategory(String category);

//    void updateQuestionById(Integer id, Questions updatedQuestion);
}
