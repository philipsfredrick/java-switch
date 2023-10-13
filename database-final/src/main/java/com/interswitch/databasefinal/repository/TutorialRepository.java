package com.interswitch.databasefinal.repository;

import com.interswitch.databasefinal.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TutorialRepository {
  Optional<Tutorial> findById(Long id);
  List<Tutorial> findAll();
  Tutorial save(Tutorial tutorial);
  void deleteById(long id);
  void deleteAll();
  void update(Tutorial tutorial, long id);
  List<Tutorial> findByPublished(boolean published);
  List<Tutorial> findByTitleContaining(String title);
}