package se331.lab.rest.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se331.lab.rest.entity.Bid;
import se331.lab.rest.repository.BidRepository;

import java.util.List;

@Service
public class BidServiceImpl implements BidService {

    @Autowired
    BidRepository bidRepository;

    @Override
    public List<Bid> getAllBids() {
        return bidRepository.findAll();
    }

    @Override
    public Bid getBidById(Long id) {
        return bidRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Bid not found"));
    }

    @Override
    public Bid saveBid(Bid bid) {
        return bidRepository.save(bid);
    }
}

