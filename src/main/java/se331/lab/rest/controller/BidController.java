package se331.lab.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se331.lab.rest.entity.Bid;
import se331.lab.rest.service.BidService;

import java.util.List;

@RestController
@RequestMapping("/bids")
public class BidController {

    @Autowired
    BidService bidService;

    @GetMapping
    public List<Bid> getAllBids() {
        return bidService.getAllBids();
    }

    @GetMapping("/{id}")
    public Bid getBidById(@PathVariable Long id) {
        return bidService.getBidById(id);
    }

    @PostMapping
    public Bid createBid(@RequestBody Bid bid) {
        return bidService.saveBid(bid);
    }
}

