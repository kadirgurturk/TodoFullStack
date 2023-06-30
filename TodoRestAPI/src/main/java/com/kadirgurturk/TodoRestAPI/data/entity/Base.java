package com.kadirgurturk.TodoRestAPI.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kadirgurturk.TodoRestAPI.data.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class Base  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "systemdate")
    private Date systemDate;
}