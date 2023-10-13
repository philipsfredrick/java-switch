package com.interswitch.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "department")
@XmlAccessorType(XmlAccessType.FIELD)
public class Department {

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "manager")
    private List<Manager> manager;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Manager> getManager() {
        return manager;
    }

    public void setManager(List<Manager> manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", manager=" + manager +
                '}';
    }
}
