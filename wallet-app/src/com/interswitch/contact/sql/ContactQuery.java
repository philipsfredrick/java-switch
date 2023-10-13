package com.interswitch.contact.sql;

import com.interswitch.contact.model.Contact;

public class ContactQuery {

    static final String INSERT_QUERY =
            "INSERT INTO contact(first_name, last_name, phone_number, sex, dob) VALUES (?,?,?,?,?)";

    public static void createContact(Contact contact) {

    }
}
