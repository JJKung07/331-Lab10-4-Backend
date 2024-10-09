package se331.lab.rest.dao;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Bid;

import java.util.List;

@Repository
public class BidDaoImpl implements BidDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Bid> getAll() {
        return entityManager.createQuery("SELECT b FROM Bid b", Bid.class).getResultList();
    }

    @Override
    public Bid getById(Long id) {
        return entityManager.find(Bid.class, id);
    }

    @Override
    public void save(Bid bid) {
        entityManager.persist(bid);
    }
}

