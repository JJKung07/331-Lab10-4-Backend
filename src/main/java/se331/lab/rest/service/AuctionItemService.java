package se331.lab.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import se331.lab.rest.entity.AuctionItem;
import se331.lab.rest.repository.AuctionItemRepository;

public interface AuctionItemService {
    Integer getAuctionItemSize();
    Page<AuctionItem> getAuctionItems(Integer pageSize, Integer page);
    AuctionItem getAuctionItem(Long id);
    AuctionItem save(AuctionItem auctionItem);
    Page<AuctionItem> getAuctionItems(String description, String type, Pageable pageable);
    Page<AuctionItem> getAuctionItemsWithSuccessfulBidLessThan(Double amount, Pageable pageable);
}
