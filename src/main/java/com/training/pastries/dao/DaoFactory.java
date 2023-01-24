package com.training.pastries.dao;

import com.training.pastries.dao.entity.Pastry;

public class DaoFactory {
    public static final Dao<Pastry> getPastryDao() {
        return new PastryDao();
    }
}
