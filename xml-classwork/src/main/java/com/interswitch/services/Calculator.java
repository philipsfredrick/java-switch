package com.interswitch.services;

import org.json.JSONObject;

public class Calculator {
    private String name;
    private int age;
    private String city;

    public Calculator(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public int add(int a, int b) {
            return a + b;
        }

        public int subtract(int a, int b) {
            return a - b;
        }


        public double calculateAverageGrade(double[] grades) {
            if (grades.length == 0) {
                return 0.0;
            }
            double sum = 0;
            for (double grade : grades) {
                sum += grade;
            }
            return sum / grades.length;
        }

    public static void main(String[] args) {
        Calculator calculator = new Calculator("Alice", 30, "New York");
//        System.out.println(calculator.calculateAverageGrade(new double[]{2.0,3.0,5.0}));

        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.getJSONObject(calculator.name);
//        jsonObject1.getJSONObject((String) calculator.age);
        jsonObject1.getJSONObject(calculator.city);
        System.out.println(jsonObject1);
    }
}
