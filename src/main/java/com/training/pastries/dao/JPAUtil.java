package com.training.pastries.dao;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public final class JPAUtil {
    private static final String PERSISTENCE_UNIT_NAME = "PU";
    public static EntityManagerFactory factory;

    private JPAUtil() {}

    public static EntityManagerFactory getEntityManagerFactory() {
        if (factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        return factory;
    }

    public static void shutDown() {
        if (factory != null)
            factory.close();
    }
}
