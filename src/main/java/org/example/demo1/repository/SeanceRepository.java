package org.example.demo1.repository;

import org.example.demo1.model.Seance;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SeanceRepository implements BaseRepo<Seance>{
    @Override
    public Integer save(Seance seance) {
        return 0;
    }

    @Override
    public Seance get(Integer id) {
        return null;
    }

    @Override
    public List<Seance> getAll() {
        return List.of();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
