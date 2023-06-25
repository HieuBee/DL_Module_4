package com.picture.repository;

import com.picture.model.Feedback;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PictureRepositoryImpl implements IPictureRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Feedback> showList() {
        List<Feedback> feedbacks = new ArrayList<>();
        TypedQuery<Feedback> query = (TypedQuery<Feedback>) entityManager.createNativeQuery("SELECT * FROM feedback WHERE date = CURDATE()", Feedback.class);
        feedbacks = query.getResultList();
        return feedbacks;
    }

    @Transactional
    @Override
    public boolean add(Feedback feedback) {
        try {
            entityManager.persist(feedback);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Transactional
    @Override
    public boolean update(int id) {
        try{
            Feedback feedback = findById(id);
            int newLike = feedback.getLiked() + 1;
            feedback.setLiked(newLike);
            entityManager.merge(feedback);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Feedback findById(int id) {
        return entityManager.find(Feedback.class, id);
    }
}
