package com.interswitch.services;

import com.interswitch.services.mapper.EmployeeHelper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class EmployeeXMLProcessor {

    public static void main(String[] args) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeHelper.xmlEmployeeObjects);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        File file = new File("work.xml");
        Employee employee = (Employee) unmarshaller.unmarshal(file);
        System.out.println(employee);
    }
}
