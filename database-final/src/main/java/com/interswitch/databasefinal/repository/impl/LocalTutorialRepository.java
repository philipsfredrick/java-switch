package com.interswitch.databasefinal.repository.impl;

import com.interswitch.databasefinal.model.Tutorial;
import com.interswitch.databasefinal.repository.TutorialRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class LocalTutorialRepository implements TutorialRepository {
    private Map<Long, Tutorial> localDB;
    public LocalTutorialRepository() {
        if (localDB == null) {
            localDB = new HashMap<>();
        }
    }
    @Override
    public Optional<Tutorial> findById(Long id) {
        return Optional.of(localDB.get(id));
    }

    @Override
    public List<Tutorial> findAll() {
        return localDB.values().stream().toList();
    }

    @Override
    public Tutorial save(Tutorial tutorial) {
        localDB.put(tutorial.getId(), tutorial);
        return localDB.get(tutorial.getId());
    }

    @Override
    public void deleteById(long id) {
        if (localDB.containsKey(id)) {
            localDB.remove(id);
        }
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void update(Tutorial tutorial, long id) {

    }

    @Override
    public List<Tutorial> findByPublished(boolean published) {
        return null;
    }

    @Override
    public List<Tutorial> findByTitleContaining(String title) {
        return null;
    }
}
