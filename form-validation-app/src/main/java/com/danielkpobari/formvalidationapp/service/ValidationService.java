package com.danielkpobari.formvalidationapp.service;

import com.danielkpobari.formvalidationapp.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ValidationService {

    public List<String> validateUser(User user) {
        List<String> errors = new ArrayList<>();

        if (!isValidUsername(user.getUsername())) {
            errors.add("Invalid username");
        }

        if (!isValidEmail(user.getEmail())) {
            errors.add("Invalid email");
        }

        if (!isValidPassword(user.getPassword())) {
            errors.add("Invalid password");
        }

        if (!isValidDateOfBirth(user.getDateOfBirth())) {
            errors.add("Invalid date of birth");
        }
        return errors;
    }

    private boolean isValidDateOfBirth(String dateOfBirth) {
        return false;
    }

    private boolean isValidPassword(String password) {
        return false;
    }

    private boolean isValidUsername(String username) {
        return false;
    }

    private boolean isValidEmail(String email) {
        return false;
    }


}
