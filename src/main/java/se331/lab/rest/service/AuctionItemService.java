package se331.lab.rest.service;

import se331.lab.rest.entity.AuctionItemDTO;

import java.math.BigDecimal;
import java.util.List;

public interface AuctionItemService {
    List<AuctionItemDTO> getAllItems();
    AuctionItemDTO getItemById(Long id);
    List<AuctionItemDTO> searchByDescription(String description); // Keep this for single description search
    List<AuctionItemDTO> searchByDescriptionOrType(String description, String type); // New method for combined search
    List<AuctionItemDTO> findBySuccessfulBidAmountLessThan(BigDecimal amount);
    AuctionItemDTO saveItem(AuctionItemDTO auctionItemDTO);
}
