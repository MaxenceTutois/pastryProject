package com.training.pastries.dao;

import com.training.pastries.dao.entity.Pastry;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PastryDao implements Dao<Pastry> {

    @Override
    public Optional<Pastry> get(Long id) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        Optional<Pastry> result = Optional.empty();
        et.begin();
        try {
            result = Optional.of(em.find(Pastry.class, id));
            et.commit();
        }
        catch (Exception e) {
            if (et.isActive())
                et.rollback();
        }
        finally {
            em.close();
        }
        return result;
    }

    @Override
    public Optional<Pastry> getByName(String like) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        Optional<Pastry> result = Optional.empty();
        et.begin();
        try {
            TypedQuery<Pastry> query = em.createQuery("SELECT p FROM Pastry p WHERE p.name LIKE :name", Pastry.class);
            query.setParameter("name", "%" + like + "%");
            query.setMaxResults(1);
            result = Optional.of(query.getSingleResult());
            et.commit();
        }
        catch (Exception e) {
            if (et.isActive())
                et.rollback();
        }
        finally {
            em.close();
        }

        return result;
    }

    @Override
    public List<Pastry> getAll() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();

        List<Pastry> pastries = new ArrayList<>();
        et.begin();
        try {
            TypedQuery<Pastry> query = em.createQuery("SELECT p FROM Pastry p", Pastry.class);
            pastries = query.getResultList();
            et.commit();
        }
        catch (Exception e) {
            if (et.isActive())
                et.rollback();
        }
        finally {
            em.close();
        }
        return pastries;
    }

    @Override
    public void create(Pastry pastry) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        try {
            em.persist(pastry);
            et.commit();
        }
        catch (Exception e) {
            if (et.isActive())
                et.rollback();
        }
        finally {
            em.close();
        }
    }

    @Override
    public void update(Pastry pastry) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.merge(pastry);
            et.commit();
        }
        catch (Exception e) {
            if (et.isActive())
                et.rollback();
        }
        finally {
            em.close();
        }
    }

    @Override
    public void delete(Pastry pastry) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        try {
            em.remove(em.contains(pastry) ? pastry : em.merge(pastry));
            et.commit();
        }
        catch (Exception e) {
            if (et.isActive())
                et.rollback();
        }
        finally {
            em.close();
        }
    }
}
