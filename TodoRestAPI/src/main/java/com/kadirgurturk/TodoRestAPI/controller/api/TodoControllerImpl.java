package com.kadirgurturk.TodoRestAPI.controller.api;

import com.kadirgurturk.TodoRestAPI.buisness.dto.TodoDto;
import com.kadirgurturk.TodoRestAPI.buisness.service.ITodoService;
import com.kadirgurturk.TodoRestAPI.error.Response;
import com.kadirgurturk.TodoRestAPI.util.FrontEndURL;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@Log4j2
@RestController
@CrossOrigin(origins = FrontEndURL.FRONTEND_URL)
@RequestMapping("/todo/api/v1")
public class TodoControllerImpl implements TodoController<TodoDto>{

    private final ITodoService todoService;

    @Override
    @PostMapping("/save")
    public ResponseEntity<TodoDto> blogServiceCreate(@Valid @RequestBody TodoDto todoDto) {

        todoService.saveTodo(todoDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(todoDto);
    }

    @Override
    @GetMapping(value = "/list")
    public ResponseEntity<List<TodoDto>> todoList() {
        return ResponseEntity.ok(todoService.todoList());
    }

    @Override
    @GetMapping(value = "/find/{id}")
    public ResponseEntity<?> findTodoById(@PathVariable(name = "id") Long id) {

        if (id == null) {

            throw new NullPointerException(id + " null değer");
        }
        if (id == 0) {

            var response  = new Response(400, "bad Request", " Kötü İstek", "/blog/api/v1/find/0");
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.ok(todoService.findTodoById(id));
    }

    @Override
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteTodoById( @PathVariable(name = "id") Long id) {

        if (id == null) {

            throw new NullPointerException(id + " null değer");
        }
        if (id == 0) {

            var response  = new Response(400, "bad Request", " Kötü İstek", "/blog/api/v1/find/0");
            return ResponseEntity.ok(response);
        }

        todoService.deleteTodoById(id);

        return ResponseEntity.ok(id + "'li değer silindi");

    }

    @Override
    @PutMapping({"/update", "/update/{id}"})
    public ResponseEntity<?> updateTodoById(
            @PathVariable(name = "id", required = false) Long id,
            @Valid @RequestBody TodoDto todoDto) {

        return ResponseEntity.ok(todoService.updateTodoById(id,todoDto));
    }

    @Override
    @DeleteMapping(value = "/delete/")
    public ResponseEntity<?> deleteByStatus(@RequestParam("status") String status) {

        todoService.deleteByStatus(status);

        var message = "All " + status + " Data Deleted";
        return ResponseEntity.ok(message);
    }

    @Override
    @DeleteMapping(value = "/deleteall")
    public ResponseEntity<?> deleteAll() {

        todoService.deleteAll();

        var message = "All  Data Deleted";

        return ResponseEntity.ok(message);

    }

    @Override
    @GetMapping(value = "/status/{status}")
    public ResponseEntity<List<TodoDto>> findByStatus(@PathVariable(name = "status")String status) {

        return ResponseEntity.status(HttpStatus.OK).body(todoService.findByStatus(status));
    }

    @Override
    @GetMapping(value = "/")
    public ResponseEntity<List<TodoDto>> findByNameContaining(@RequestParam("name") String value) {

        return ResponseEntity.status(HttpStatus.OK).body(todoService.findByNameContaining(value));

    }

    @GetMapping(value = "/list/page/")
    public ResponseEntity<List<TodoDto>> todoPagination(@RequestParam("page")int currentPage,
                                                        @RequestParam("size")int pageSize) {
        return ResponseEntity.status(HttpStatus.OK).body(todoService.todoPagination(currentPage,pageSize));
    }

    @Override
    @GetMapping(value = "/list/sort/")
    public ResponseEntity<List<TodoDto>> todoSort(@RequestParam(name = "field") String field) {

        return ResponseEntity.status(HttpStatus.OK).body(todoService.todoSort(field));
    }
}
