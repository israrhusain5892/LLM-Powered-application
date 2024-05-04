package com.LLM.LLMpoweredapplication;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
public class Company {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

     private String entity;
     private String parameter;
     @JsonFormat(pattern = "yyyy-MM-dd")
     private Date startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
     private Date endDate;
}
