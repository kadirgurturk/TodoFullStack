package com.kadirgurturk.TodoRestAPI.controller.api;

import com.kadirgurturk.TodoRestAPI.buisness.dto.TodoDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TodoController<D> {



    ResponseEntity<D> blogServiceCreate(D d);

    ResponseEntity<List<D>> todoList();

    ResponseEntity<?> findTodoById(Long id);

    ResponseEntity<?> deleteTodoById(Long id);

    ResponseEntity<?> updateTodoById(Long id, D d);

    ResponseEntity<?> deleteByStatus(String status);

    ResponseEntity<?> deleteAll();

    ResponseEntity<List<D>> findByStatus(String status);

    ResponseEntity<List<D>> findByNameContaining(String value);

    ResponseEntity<List<D>> todoPagination(int currentPage, int pageSize);

    ResponseEntity<List<D>> todoSort(String field);


}
