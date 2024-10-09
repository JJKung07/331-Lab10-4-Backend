package se331.lab.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Bid;

@Repository
public interface BidRepository extends JpaRepository<Bid, Long> {
}

