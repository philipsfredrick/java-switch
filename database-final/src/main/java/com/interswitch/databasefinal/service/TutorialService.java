package com.interswitch.databasefinal.service;

import com.interswitch.databasefinal.model.Tutorial;

import java.util.List;

public interface TutorialService {

    public List<Tutorial> getTutorials();
    public Tutorial addTutorial(Tutorial tutorial);

    public Tutorial getTutorialById(long id);

    public Tutorial updateTutorial(Tutorial tutorial, long id);

    public void deleteTutorial(long id);

}
