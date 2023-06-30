package com.kadirgurturk.TodoRestAPI.data.repository;

import com.kadirgurturk.TodoRestAPI.data.entity.Todo;
import com.kadirgurturk.TodoRestAPI.data.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findByStatus(Status status);

    void deleteByStatus(Status status);

    List<Todo> findByNameContaining(String value);

}
