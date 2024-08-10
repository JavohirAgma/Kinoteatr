package org.example.demo1.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseRepo<M>{

    Integer save(M m);
    M get(Integer id);
    List<M> getAll();
    boolean delete(Integer id);
}
