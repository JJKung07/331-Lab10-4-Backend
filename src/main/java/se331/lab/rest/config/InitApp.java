package se331.lab.rest.config;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import se331.lab.rest.entity.AuctionItem;
import se331.lab.rest.entity.Bid;
import se331.lab.rest.repository.AuctionItemRepository;
import se331.lab.rest.repository.BidRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@Profile("db")
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final AuctionItemRepository auctionItemRepository;
    final BidRepository bidRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        // Create Auction Items
        AuctionItem item1 = auctionItemRepository.save(AuctionItem.builder()
                .description("Antique Vase")
                .type("Antique")
                .build());
        AuctionItem item2 = auctionItemRepository.save(AuctionItem.builder()
                .description("Vintage Car")
                .type("Vehicle")
                .build());
        AuctionItem item3 = auctionItemRepository.save(AuctionItem.builder()
                .description("Luxury Watch")
                .type("Jewelry")
                .build());
        AuctionItem item4 = auctionItemRepository.save(AuctionItem.builder()
                .description("Painting by a Famous Artist")
                .type("Art")
                .build());
        AuctionItem item5 = auctionItemRepository.save(AuctionItem.builder()
                .description("Rare Book Collection")
                .type("Books")
                .build());

        // Create Bids for Auction Items
        // AuctionItem 1 bids
        Bid bid1 = bidRepository.save(Bid.builder()
                .amount(new BigDecimal("100.00"))
                .datetime(LocalDateTime.now().minusDays(2))
                .auctionItem(item1)
                .build());
        Bid bid2 = bidRepository.save(Bid.builder()
                .amount(new BigDecimal("150.00"))
                .datetime(LocalDateTime.now().minusDays(1))
                .auctionItem(item1)
                .build());
        Bid bid3 = bidRepository.save(Bid.builder()
                .amount(new BigDecimal("200.00"))  // Successful bid
                .datetime(LocalDateTime.now())
                .auctionItem(item1)
                .build());
        item1.setSuccessfulBid(bid3);

        // AuctionItem 2 bids
        Bid bid4 = bidRepository.save(Bid.builder()
                .amount(new BigDecimal("5000.00"))
                .datetime(LocalDateTime.now().minusDays(3))
                .auctionItem(item2)
                .build());
        Bid bid5 = bidRepository.save(Bid.builder()
                .amount(new BigDecimal("6000.00"))
                .datetime(LocalDateTime.now().minusDays(2))
                .auctionItem(item2)
                .build());
        Bid bid6 = bidRepository.save(Bid.builder()
                .amount(new BigDecimal("7000.00"))  // Successful bid
                .datetime(LocalDateTime.now())
                .auctionItem(item2)
                .build());
        item2.setSuccessfulBid(bid6);

        // AuctionItem 3 bids
        Bid bid7 = bidRepository.save(Bid.builder()
                .amount(new BigDecimal("1000.00"))
                .datetime(LocalDateTime.now().minusDays(1))
                .auctionItem(item3)
                .build());
        Bid bid8 = bidRepository.save(Bid.builder()
                .amount(new BigDecimal("1200.00"))
                .datetime(LocalDateTime.now().minusHours(5))
                .auctionItem(item3)
                .build());
        Bid bid9 = bidRepository.save(Bid.builder()
                .amount(new BigDecimal("1500.00"))  // Successful bid
                .datetime(LocalDateTime.now())
                .auctionItem(item3)
                .build());
        item3.setSuccessfulBid(bid9);

        // AuctionItem 4 bids (no successful bid)
        Bid bid10 = bidRepository.save(Bid.builder()
                .amount(new BigDecimal("500.00"))
                .datetime(LocalDateTime.now().minusDays(4))
                .auctionItem(item4)
                .build());
        Bid bid11 = bidRepository.save(Bid.builder()
                .amount(new BigDecimal("700.00"))
                .datetime(LocalDateTime.now().minusDays(2))
                .auctionItem(item4)
                .build());
        Bid bid12 = bidRepository.save(Bid.builder()
                .amount(new BigDecimal("900.00"))
                .datetime(LocalDateTime.now().minusHours(10))
                .auctionItem(item4)
                .build());

        // AuctionItem 5 bids (no successful bid)
        Bid bid13 = bidRepository.save(Bid.builder()
                .amount(new BigDecimal("300.00"))
                .datetime(LocalDateTime.now().minusDays(6))
                .auctionItem(item5)
                .build());
        Bid bid14 = bidRepository.save(Bid.builder()
                .amount(new BigDecimal("400.00"))
                .datetime(LocalDateTime.now().minusDays(3))
                .auctionItem(item5)
                .build());
        Bid bid15 = bidRepository.save(Bid.builder()
                .amount(new BigDecimal("500.00"))
                .datetime(LocalDateTime.now().minusHours(2))
                .auctionItem(item5)
                .build());

        // Save Auction Items with their Bids
        auctionItemRepository.save(item1);
        auctionItemRepository.save(item2);
        auctionItemRepository.save(item3);
        auctionItemRepository.save(item4);
        auctionItemRepository.save(item5);
    }
}
