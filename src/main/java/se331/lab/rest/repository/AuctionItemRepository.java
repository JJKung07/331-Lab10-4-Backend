package se331.lab.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.AuctionItem;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface AuctionItemRepository extends JpaRepository<AuctionItem, Long> {
    List<AuctionItem> findByDescriptionContaining(String description);
    List<AuctionItem> findByTypeContaining(String type);
    List<AuctionItem> findBySuccessfulBid_AmountLessThan(BigDecimal amount);
}

