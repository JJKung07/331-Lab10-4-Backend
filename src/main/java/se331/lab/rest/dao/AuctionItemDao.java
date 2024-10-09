package se331.lab.rest.dao;

import se331.lab.rest.entity.AuctionItem;

import java.math.BigDecimal;
import java.util.List;

public interface AuctionItemDao {
    List<AuctionItem> getAll();
    AuctionItem getById(Long id);
    List<AuctionItem> searchByDescription(String description);
    List<AuctionItem> searchBySuccessfulBidLessThan(BigDecimal amount);
    void save(AuctionItem auctionItem);
}

