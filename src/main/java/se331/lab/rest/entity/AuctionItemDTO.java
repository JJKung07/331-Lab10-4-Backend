package se331.lab.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuctionItemDTO {
    private Long id;
    private String description;
    private String type;
    private List<BidDTO> bids; // Use BidDTO to prevent infinite loop
    private BidDTO successfulBid; // Use BidDTO to prevent infinite loop
}
