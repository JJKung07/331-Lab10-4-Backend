package se331.lab.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se331.lab.rest.entity.AuctionItemDTO;
import se331.lab.rest.service.AuctionItemService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/auction-items")
public class AuctionItemController {

    @Autowired
    AuctionItemService auctionItemService;

    @GetMapping
    public List<AuctionItemDTO> getAllItems() {
        return auctionItemService.getAllItems();
    }

    @GetMapping("/{id}")
    public AuctionItemDTO getItemById(@PathVariable Long id) {
        return auctionItemService.getItemById(id);
    }

    @GetMapping("/search/description")
    public List<AuctionItemDTO> searchByDescription(@RequestParam String description) {
        return auctionItemService.searchByDescription(description);
    }

    @GetMapping("/search")
    public List<AuctionItemDTO> searchByDescriptionOrType(@RequestParam(required = false) String description,
                                                          @RequestParam(required = false) String type) {
        return auctionItemService.searchByDescriptionOrType(description, type);
    }

    @GetMapping("/successful-bid/less-than")
    public List<AuctionItemDTO> searchBySuccessfulBidAmountLessThan(@RequestParam BigDecimal amount) {
        return auctionItemService.findBySuccessfulBidAmountLessThan(amount);
    }

    @PostMapping
    public AuctionItemDTO createAuctionItem(@RequestBody AuctionItemDTO auctionItemDTO) {
        return auctionItemService.saveItem(auctionItemDTO);
    }
}
