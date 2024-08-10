package org.example.demo1.repository;

import org.example.demo1.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepository implements BaseRepo<Movie>{
    @Override
    public Integer save(Movie movie) {
        return 0;
    }

    @Override
    public Movie get(Integer id) {
        return null;
    }

    @Override
    public List<Movie> getAll() {
        return List.of();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
