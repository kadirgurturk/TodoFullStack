package com.kadirgurturk.TodoRestAPI.buisness.dto;



import com.fasterxml.jackson.annotation.JsonInclude;
import com.kadirgurturk.TodoRestAPI.data.enums.Status;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Log4j2
public class TodoDto implements Serializable {
    public static final Long serialVersionUID = 1L;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;

    @NotEmpty(message = "Name boş olamaz")
    @Size(min = 3, message = "Name değeri 3 karaktereden az olamaz")
    private String name;

    private Status status;


}