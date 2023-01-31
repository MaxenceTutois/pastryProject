package com.training.pastries.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<ID, T> {
    Optional<T> get(ID id);

    List<T> getAll();

    void create(T t);

    void update(T t);

    void delete(T t);
}
