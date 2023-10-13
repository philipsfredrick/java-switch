package com.interswitch.databasefinal.service;


import com.interswitch.databasefinal.model.Tutorial;
import com.interswitch.databasefinal.repository.TutorialRepository;
import com.interswitch.databasefinal.repository.impl.JpaTutorialRepository;
import com.interswitch.databasefinal.repository.impl.LocalTutorialRepository;
import com.interswitch.databasefinal.service.impl.TutorialServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
public class TutorialServiceTest {
    private TutorialRepository  tutorialRepository;
    private TutorialService tutorialService;

    @BeforeEach
    public void setUp() {
        //tutorialRepository = mock(LocalTutorialRepository.class);
        tutorialRepository = mock(JpaTutorialRepository.class);
        tutorialService = new TutorialServiceImpl(tutorialRepository);
    }
    @Test
    void testGetAllTutorials() {
        List<Tutorial> tutorials = new ArrayList<>();
        tutorials.add(new Tutorial(1L, "Book 1",
                "Title 1", true));
        tutorials.add(new Tutorial(2L, "Book 2",
                "Title 2", false));

        when(tutorialService.getTutorials())
                .thenReturn(tutorials);
    }
    @Test
    void testWhenTutorialIsPublishedReturnTrue() {
        Tutorial first = new Tutorial(2L,
                "Book 2", "Title 2", true);
        assertThat(first.isPublished()).isTrue();
    }
    @Test
    void testWhenTutorialAddedReturnId() {
        Tutorial tutorial = new Tutorial(2L, "Title 1",
                "Description", true);
        when(tutorialService.addTutorial(tutorial))
                .thenReturn(tutorial);
    }

    @Test
    void testWhenTutorialTitleNotNull() {
        Tutorial first = new Tutorial(2L, "Book 2",
                "Title 2", false);
        assertThat(first.getTitle()).isNotEmpty();
    }

 }
