package se331.lab.rest.service;

import se331.lab.rest.entity.Bid;

import java.util.List;

public interface BidService {
    List<Bid> getAllBids();
    Bid getBidById(Long id);
    Bid saveBid(Bid bid);
}

