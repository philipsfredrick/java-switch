package com.example.javajacksonjsonapp.converter;

import com.example.javajacksonjsonapp.pojo.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class JsonToJavaConverter {

    public static void main(String[] args) throws Exception {
//        convertJsonToObject();
        convertJsonToObjects();
    }

    public static void convertJsonToObject() throws Exception {
        File file = new File("stud.json");
        ObjectMapper mapper = new ObjectMapper();
        Student student = mapper.readValue(file, Student.class);
        System.out.println(student);
    }

    public static void convertJsonToObjects() throws Exception {
        File file = new File("students.json");
        ObjectMapper mapper = new ObjectMapper();
        Student[] students = mapper.readValue(file, Student[].class);
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
