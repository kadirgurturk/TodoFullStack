package com.kadirgurturk.TodoRestAPI.buisness.service;

import com.kadirgurturk.TodoRestAPI.buisness.dto.TodoDto;
import com.kadirgurturk.TodoRestAPI.data.entity.Todo;
import com.kadirgurturk.TodoRestAPI.data.enums.Status;
import com.kadirgurturk.TodoRestAPI.data.repository.TodoRepository;
import com.kadirgurturk.TodoRestAPI.exception.BadRequestException;
import com.kadirgurturk.TodoRestAPI.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.kadirgurturk.TodoRestAPI.bean.ModalMapperBean;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Log4j2
@Service //
public class TodoService implements ITodoService<TodoDto, Todo>{

    private final ModalMapperBean modelMapperBean;
    private final TodoRepository todoRepository;


    @Override
    public TodoDto EntityToDto(Todo todo) {
        return modelMapperBean.modalMapper().map(todo,TodoDto.class);
    }

    @Override
    public Todo DtoToEntity(TodoDto todoDto) {
        return modelMapperBean.modalMapper().map(todoDto,Todo.class);
    }

    @Transactional
    @Override
    public TodoDto saveTodo(TodoDto todoDto) {

        if (todoDto != null) {
            Todo todoNew = DtoToEntity(todoDto);
            Todo todo = todoRepository.save(todoNew);

        } else if (todoDto == null)
            throw new BadRequestException("todoDto yoktur");
        return todoDto;
    }

    @Override
    public List<TodoDto> todoList() {
        Iterable<Todo> todoList = todoRepository.findAll();
        List<TodoDto> todoDtolist = new ArrayList<>();
        for (Todo entity : todoList) {      //------> Repodan gelen entityleri DTO haline getirip listeyi dönüyoruz.
            TodoDto todoDto = EntityToDto(entity);
            todoDtolist.add(todoDto);
        }
        return todoDtolist;
    }


    @Override
    public TodoDto findTodoById(Long id) {
        Todo todo = null;
        if (id != null) {
            todo = todoRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException(id + " nolu ID bulunamadı"));
        } else if (id == null) throw new BadRequestException(id + "Girilen Id geçersiz");


        return EntityToDto(todo);
    }

    @Transactional
    @Override
    public TodoDto deleteTodoById(Long id) {
        if(id != null){
            Todo todo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id + " nolu ID bulunamadı"));
            todoRepository.delete(todo);
            return EntityToDto(todo);

        }else{
            throw new BadRequestException(id + "Girilen Id geçersiz");
        }

        //  ---> Önce id değerinin geçerli olup olamadığına baktık sonra, bu id değerinde Entity olup olmadığına baktık

    }
    @Transactional
    @Override
    public TodoDto updateTodoById(Long id, TodoDto todoDto) {

        Todo todo = DtoToEntity(findTodoById(id));
        if (todo != null) {
            todo.setId(id);
            todo.setName(todoDto.getName());
            todo.setStatus(todoDto.getStatus());
            todoRepository.save(todo);

            // ------------> Update işlemi gerçekleşir.
        }
        return EntityToDto(todo);
    }

    @Transactional
    @Override
    public void deleteByStatus(String status) {


        todoRepository.deleteByStatus(Status.valueOf(status));


    }

    @Override
    public List<TodoDto> findByStatus(String status) {


        status = status.toUpperCase(Locale.ROOT).trim();


        if(status.equals("DONE") || status.equals("TODO")){
            return (StreamSupport.stream(todoRepository.findByStatus(Status.valueOf(status)).spliterator(),false))
                    .map(this::EntityToDto)
                    .collect(Collectors.toList());

            // ---------------> DONE veya TODO için sorting yapmadan önce, gelen değerin geçerli olup olmadığına emin olduk.
        }

        throw new BadRequestException("Status DONE veya TODO girilmeli");

    }

    @Override
    public void deleteAll() {
        todoRepository.deleteAll();

    }

    @Override
    public List<TodoDto> findByNameContaining(String value) {

        return (StreamSupport.stream(todoRepository.findByNameContaining(value).spliterator(),false))
                .map(this::EntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<TodoDto> todoPagination(int currentPage, int pageSize) {
        PageRequest pageable = PageRequest.of(currentPage,pageSize);

        return (StreamSupport.stream(todoRepository.findAll(pageable).spliterator(),false))
                .map(this::EntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<TodoDto> todoSort(String field) {
        List<TodoDto> todoDtoList = new ArrayList<>();

        for(Todo todo : todoRepository.findAll(Sort.by(field)) ){
           ;
            todoDtoList.add( EntityToDto(todo));
        }

        return todoDtoList;

    }
}
