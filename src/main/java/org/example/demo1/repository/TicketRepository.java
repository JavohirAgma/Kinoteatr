package org.example.demo1.repository;

import org.example.demo1.model.Ticket;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TicketRepository implements BaseRepo<Ticket>{
    @Override
    public Integer save(Ticket ticket) {
        return 0;
    }

    @Override
    public Ticket get(Integer id) {
        return null;
    }

    @Override
    public List<Ticket> getAll() {
        return List.of();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
