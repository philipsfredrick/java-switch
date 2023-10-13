package com.interswitch.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "phone-number")
@XmlAccessorType(XmlAccessType.FIELD)
public class PhoneNumber {

    @XmlElement(name = "work")
    private String work;

    @XmlElement(name = "home")
    private String home;

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    @Override
    public String toString() {
        if (home == null) {
            return "PhoneNumber{" +
                    "work='" + work + '\'' +
                    '}';
        } else {
            return "PhoneNumber{" +
                    "work='" + work + '\'' +
                    ", home='" + home + '\'' +
                    '}';
        }
    }
}
