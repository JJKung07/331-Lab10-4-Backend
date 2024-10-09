package se331.lab.rest.dao;

import se331.lab.rest.entity.Bid;

import java.util.List;

public interface BidDao {
    List<Bid> getAll();
    Bid getById(Long id);
    void save(Bid bid);
}

