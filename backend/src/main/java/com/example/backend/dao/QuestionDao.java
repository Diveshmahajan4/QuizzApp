package com.example.backend.dao;

import com.example.backend.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Questions, Integer> {

    // JPA will automatically return a list according to category, you don't have to write
    // separate sql queries.
    List<Questions> findByCategory(String category);

    @Query(value = "SELECT * FROM questions q WHERE q.category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery =
            true)
    List<Questions> findRandomQuestionByCategory(String category, int numQ);

    //    void updateQuestionById(Integer id, Questions updatedQuestion);
}
