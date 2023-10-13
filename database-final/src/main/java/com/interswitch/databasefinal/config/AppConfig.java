package com.interswitch.databasefinal.config;

import com.interswitch.databasefinal.repository.TutorialRepository;
import com.interswitch.databasefinal.repository.impl.JpaTutorialRepository;
import com.interswitch.databasefinal.repository.impl.LocalTutorialRepository;
import com.interswitch.databasefinal.service.TutorialService;
import com.interswitch.databasefinal.service.impl.TutorialServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

    @Bean
    @ConditionalOnProperty(name = "tutorial-repo",
            havingValue = "local")
    public TutorialRepository tutorialRepository() {
        System.out.println("Injecting " + LocalTutorialRepository.class.getName());
        return new LocalTutorialRepository();
    }

    @Bean
    @ConditionalOnProperty(name = "tutorial-repo",
            havingValue = "jpa")
    public TutorialRepository tutorialRepositoryJpa() {
        System.out.println("Injecting " + JpaTutorialRepository.class.getName());
        return new JpaTutorialRepository();
    }

    @Bean
    public TutorialService tutorialService() {
        return new TutorialServiceImpl(tutorialRepository());
    }
}
