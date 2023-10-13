package com.interswitch.databasefinal.service;

import com.interswitch.databasefinal.model.Tutorial;

import java.util.List;

public interface TutorialService {

    List<Tutorial> getTutorials();

    Tutorial addTutorial(Tutorial tutorial);
}
