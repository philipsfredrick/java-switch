package com.example.javajacksonjsonapp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private Integer studId;
    private String studName;
    private String studSkill;
}
