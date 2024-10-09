package se331.lab.rest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AuctionItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;

    String name;
    String description;
    String types;

    @OneToMany(mappedBy = "auctionItem", cascade = CascadeType.ALL)
    List<Bid> bids = new ArrayList<>();

    @OneToOne
    Bid successfulBid;
}
