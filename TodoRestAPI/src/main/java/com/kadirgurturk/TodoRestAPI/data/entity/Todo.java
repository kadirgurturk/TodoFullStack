package com.kadirgurturk.TodoRestAPI.data.entity;

import com.kadirgurturk.TodoRestAPI.data.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "todo")
public class Todo extends Base{

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    @Enumerated(EnumType.STRING) //-> Bu tipin enum olacağını ve database'de bu tipin stirng değerini tutması gerektiğini söyeledik
    Status status;

}
