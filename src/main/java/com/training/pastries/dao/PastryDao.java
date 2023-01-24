package com.training.pastries.dao;

import com.training.pastries.dao.entity.Pastry;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class PastryDao implements Dao<Pastry> {

    private EntityManager em;

    public PastryDao() {
        em = Persistence.createEntityManagerFactory("PU").createEntityManager();
    }

    @Override
    public Optional<Pastry> get(Long id) {
        return null;
    }

    @Override
    public List<Pastry> getAll() {
        TypedQuery<Pastry> query = em.createQuery("SELECT p FROM Pastry p", Pastry.class);
        List<Pastry> pastries = query.getResultList();
        em.close();

        return pastries;
    }

    @Override
    public void save(Pastry pastry) {
        if (pastry != null) {
            em.getTransaction().begin();
            em.persist(pastry);
            em.getTransaction().commit();

            em.close();
        }
    }

    @Override
    public void update(Pastry pastry) {

    }

    @Override
    public void delete(Pastry pastry) {
        if (pastry != null) {
            em.getTransaction().begin();
            em.remove(pastry);
            em.getTransaction().commit();

            em.close();
        }
    }
}
