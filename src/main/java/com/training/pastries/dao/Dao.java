package com.training.pastries.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    Optional<T> get(Long id);

    Optional<T> getByName(String like);

    List<T> getAll();

    void create(T t);

    void update(T t);

    void delete(T t);
}
