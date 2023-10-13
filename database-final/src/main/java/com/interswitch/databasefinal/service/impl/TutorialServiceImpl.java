package com.interswitch.databasefinal.service.impl;

import com.interswitch.databasefinal.model.Tutorial;
import com.interswitch.databasefinal.repository.TutorialRepository;
import com.interswitch.databasefinal.service.TutorialService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

public class TutorialServiceImpl implements TutorialService {
//    @Qualifier(value = "tutorialRepositoryJpa")
    private final TutorialRepository tutorialRepository;

    public TutorialServiceImpl(TutorialRepository tutorialRepository) {
        this.tutorialRepository = tutorialRepository;
    }

    @Override
    public List<Tutorial> getTutorials() {
        return tutorialRepository.findAll();
    }
    @Override
    public Tutorial addTutorial(Tutorial tutorial) {
        return tutorialRepository.save(tutorial);
    }

    @Override
    public Tutorial getTutorialById(long id) {
        return tutorialRepository.findById(id).get();
    }

    @Override
    public Tutorial updateTutorial(Tutorial tutorial, long id) {
        if (getTutorialById(id) == null) return null;
        tutorialRepository.update(tutorial, id);
        tutorial.setId(id);
        return tutorial;
    }

    @Override
    public void deleteTutorial(long id) {
        tutorialRepository.deleteById(id);
    }
}
