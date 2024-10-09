package se331.lab.rest.dao;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.AuctionItem;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class AuctionItemDaoImpl implements AuctionItemDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<AuctionItem> getAll() {
        return entityManager.createQuery("SELECT a FROM AuctionItem a", AuctionItem.class).getResultList();
    }

    @Override
    public AuctionItem getById(Long id) {
        return entityManager.find(AuctionItem.class, id);
    }

    @Override
    public List<AuctionItem> searchByDescription(String description) {
        return entityManager.createQuery("SELECT a FROM AuctionItem a WHERE a.description LIKE :desc", AuctionItem.class)
                .setParameter("desc", "%" + description + "%")
                .getResultList();
    }

    @Override
    public List<AuctionItem> searchBySuccessfulBidLessThan(BigDecimal amount) {
        return entityManager.createQuery("SELECT a FROM AuctionItem a WHERE a.successfulBid.amount < :amount", AuctionItem.class)
                .setParameter("amount", amount)
                .getResultList();
    }

    @Override
    public void save(AuctionItem auctionItem) {
        entityManager.persist(auctionItem);
    }
}

