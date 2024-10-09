package se331.lab.rest.entity;

import lombok.*;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuctionItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String description;
    String type;

    @OneToMany(mappedBy = "auctionItem")
    List<Bid> bids;

    @Setter
    @OneToOne
    Bid successfulBid;

}
