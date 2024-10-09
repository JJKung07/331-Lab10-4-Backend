package se331.lab.rest.entity;


import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    double amount;
    String dateTime;

    @ManyToOne
    AuctionItem auctionItem;
}
