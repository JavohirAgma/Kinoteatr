package org.example.demo1.repository;

import org.example.demo1.model.Hall;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HallRepository implements BaseRepo<Hall>{
    @Override
    public Integer save(Hall hall) {
        return 0;
    }

    @Override
    public Hall get(Integer id) {
        return null;
    }

    @Override
    public List<Hall> getAll() {
        return List.of();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
