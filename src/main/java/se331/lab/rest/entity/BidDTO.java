package se331.lab.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BidDTO {
    private Long id;
    private BigDecimal amount;
    private LocalDateTime datetime;
    private Long auctionItemId; // To reference the auction item without creating a loop
}
