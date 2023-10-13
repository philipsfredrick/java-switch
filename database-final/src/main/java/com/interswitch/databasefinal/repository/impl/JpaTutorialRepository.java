package com.interswitch.databasefinal.repository.impl;

import com.interswitch.databasefinal.model.Tutorial;
import com.interswitch.databasefinal.repository.TutorialRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public class JpaTutorialRepository implements TutorialRepository {
    @PersistenceContext
    private EntityManager em;
    @Override
    public Optional<Tutorial> findById(Long id) {
        TypedQuery<Tutorial> query =
                em.createQuery("SELECT t from Tutorial " +
                                "t WHERE t.id =:id",
                Tutorial.class);
        return Optional.of(query.setParameter("id", id)
                .getSingleResult()) ;
    }
    @Override
    public List<Tutorial> findAll() {
        TypedQuery<Tutorial> query = em.createQuery("SELECT t " +
                "from Tutorial t", Tutorial.class);
        return query.getResultList();
    }
    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public Tutorial save(Tutorial tutorial) {
        em.persist(tutorial);
        return tutorial;
        //throw new IllegalArgumentException("Not implemented yet.");
    }
    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void deleteById(long id) {
        Tutorial t = findById(id).get();
        if (t != null) {
            em.remove(t);
        }
    }
    @Override
    public void deleteAll() {}

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void update(Tutorial tutorial, long id) {
        if (findById(id).get() != null) {
            em.merge(tutorial);
        }

    }

    @Override
    public List<Tutorial> findByPublished(boolean published) {
        return null;
//        return jpaRepository.findAll().stream().filter(tutorial -> {
//            if(tutorial.isPublished() == published) {
//                return true;
//            }
//            return false;
//        }).toList();
    }

    @Override
    public List<Tutorial> findByTitleContaining(String title) {
        return null;
//        return jpaRepository.findAll().stream().filter(tutorial -> {
//            if(tutorial.getTitle().contains(title)) {
//                return true;
//            }
//            return false;
//        }).toList();
    }
}
