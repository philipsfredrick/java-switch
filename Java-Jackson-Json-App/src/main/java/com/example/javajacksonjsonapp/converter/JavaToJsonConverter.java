package com.example.javajacksonjsonapp.converter;

import com.example.javajacksonjsonapp.pojo.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class JavaToJsonConverter {

    public static void main(String[] args) throws JsonProcessingException {
        Student student1 = new Student();
        student1.setStudId(201);
        student1.setStudName("John");
        student1.setStudSkill("Java");

        Student student2 = new Student();
        student2.setStudId(202);
        student2.setStudName("Nick");
        student2.setStudSkill("Python");

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);


        ObjectMapper mapper = new ObjectMapper();
        String studJsn = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(students);
        System.out.println(studJsn);
    }
}
