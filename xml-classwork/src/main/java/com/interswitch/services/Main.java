package com.interswitch.services;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws JAXBException, JsonProcessingException {
//       marshal();
//       unmarshall();

        Circle circle = new Circle(5.0);
        Rectangle rectangle = new Rectangle(4, 6);

        double circleArea = circle.calculateArea();
        System.out.println(circleArea);

        int rectangleArea = rectangle.calculateArea();
        System.out.println(rectangleArea);
    }

    // Create method to unmarshall to Java Object
    private static void unmarshall() throws JAXBException, JsonProcessingException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        Employee employee = (Employee) unmarshaller.unmarshal(new File("work.xml"));
        System.out.println(employee);

        ObjectMapper mapper = new ObjectMapper();
        String employeeJsn = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
        System.out.println(employeeJsn);

        JSONObject jsonObject = new JSONObject(employee);
        System.out.println(jsonObject);



    }

    // Create method to marshall Java Objects to XML
    public static void marshal() throws JAXBException {

        // Create phone number
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setWork("08069567890");
        phoneNumber.setHome("08069567890");


        // Create address
        Address address = new Address();
        address.setCity("Wuse II");
        address.setHouseNumber("7 Obafemi Street");
        address.setPostalCode("232323");
        address.setState("FCT Abuja");

        // Create Manager
        Manager manager = new Manager();
        manager.setName("Muhammad Ali");
        manager.setPhoneNumber(new ArrayList<>());

        // Get manager phone number
        PhoneNumber managerPhone = new PhoneNumber();
        managerPhone.setWork("07089765411");

        // add manager phone number
        manager.getPhoneNumber().add(managerPhone);

        // Create department
        Department department = new Department();
        department.setName("IT");
        department.setManager(new ArrayList<>());

        // add manager to department
        department.getManager().add(manager);


        Employee employee = new Employee();

        employee.setName("Olanrewaju Ali");
        employee.setPhoneNumber(new ArrayList<>());
        employee.setAddress(new ArrayList<>());
        employee.setDepartment(new ArrayList<>());

        // add the phone number to employee
        employee.getPhoneNumber().add(phoneNumber);

        // add address to employee
        employee.getAddress().add(address);

        // add department to employee
        employee.getDepartment().add(department);

        JAXBContext context = JAXBContext.newInstance(Employee.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);

        // Marshal the employees list in console
        m.marshal(employee, System.out);
    }

//    private static void toJson() throws JsonProcessingException {
//
//        ObjectMapper mapper = new ObjectMapper();
//        String studJsn = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(students);
//        System.out.println(studJsn);
//    }
}