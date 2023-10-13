package com.interswitch.databasefinal.service;

import com.interswitch.databasefinal.model.Tutorial;
import com.interswitch.databasefinal.repository.TutorialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TutorialServiceImpl implements TutorialService{

    private final TutorialRepository tutorialRepository;
    @Override
    public List<Tutorial> getTutorials() {
        return tutorialRepository.findAll();
    }

    @Override
    public Tutorial addTutorial(Tutorial tutorial) {
        return tutorialRepository.save(tutorial);
    }
}
