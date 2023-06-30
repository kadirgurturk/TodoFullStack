package com.kadirgurturk.TodoRestAPI.buisness.service;

import com.kadirgurturk.TodoRestAPI.data.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITodoService<D, E>  {

     D EntityToDto(E e);

     E DtoToEntity(D d);

     D saveTodo(D d);

     List<D> todoList();

     D findTodoById(Long id);

     D deleteTodoById(Long id);

     D updateTodoById(Long id, D d);

     void deleteByStatus(String status);

     void deleteAll();

     List<D> findByNameContaining(String value);

     List<D> findByStatus(String status);

     List<D> todoPagination(int currentPage, int pageSize);

     List<D> todoSort(String field);
}