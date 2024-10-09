package se331.lab.rest.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se331.lab.rest.entity.AuctionItem;
import se331.lab.rest.entity.AuctionItemDTO;
import se331.lab.rest.repository.AuctionItemRepository;
import se331.lab.rest.util.LabMapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuctionItemServiceImpl implements AuctionItemService {

    @Autowired
    AuctionItemRepository auctionItemRepository;

    private final LabMapper labMapper = LabMapper.INSTANCE;

    @Override
    public List<AuctionItemDTO> getAllItems() {
        List<AuctionItem> auctionItems = auctionItemRepository.findAll();
        return labMapper.toAuctionItemDTOs(auctionItems);
    }

    @Override
    public AuctionItemDTO getItemById(Long id) {
        AuctionItem auctionItem = auctionItemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("AuctionItem not found"));
        return labMapper.toAuctionItemDTO(auctionItem);
    }

    @Override
    public List<AuctionItemDTO> searchByDescription(String description) {
        return searchByDescriptionOrType(description, null);
    }

    @Override
    public List<AuctionItemDTO> searchByDescriptionOrType(String description, String type) {
        List<AuctionItem> auctionItems = new ArrayList<>();

        if (description != null && !description.isEmpty()) {
            auctionItems.addAll(auctionItemRepository.findByDescriptionContaining(description));
        }

        if (type != null && !type.isEmpty()) {
            auctionItems.addAll(auctionItemRepository.findByTypeContaining(type));
        }

        return labMapper.toAuctionItemDTOs(auctionItems);
    }

    @Override
    public List<AuctionItemDTO> findBySuccessfulBidAmountLessThan(BigDecimal amount) {
        List<AuctionItem> auctionItems = auctionItemRepository.findBySuccessfulBid_AmountLessThan(amount);
        return labMapper.toAuctionItemDTOs(auctionItems);
    }

    @Override
    public AuctionItemDTO saveItem(AuctionItemDTO auctionItemDTO) {
        AuctionItem auctionItem = labMapper.toAuctionItem(auctionItemDTO);
        auctionItem = auctionItemRepository.save(auctionItem);
        return labMapper.toAuctionItemDTO(auctionItem);
    }
}
