package se331.lab.rest.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.lab.rest.service.AuctionItemService;


@Service
@RequiredArgsConstructor
public class AuctionItemServiceImpl implements AuctionItemService {
    @Autowired
    final AuctionItemDao auctionItemDao;

    @Override
    public Integer getAuctionItemSize() {
        return auctionItemDao.getAuctionItemSize();
    }

    @Override
    public Page<AuctionItem> getAuctionItems(Integer pageSize, Integer page) {
        return auctionItemDao.getAuctionItems(pageSize, page);
    }

    @Override
    public AuctionItem getAuctionItem(Long id) {
        return auctionItemDao.getAuctionItem(id);
    }

    @Override
    @Transactional
    public AuctionItem save(AuctionItem auctionItem) {
        // You can perform any additional logic here before saving, e.g. setting a default bid or validating data
        return auctionItemDao.save(auctionItem);
    }

    @Override
    public Page<AuctionItem> getAuctionItems(String description, String type, Pageable pageable) {
        return auctionItemDao.getAuctionItems(description, type, pageable);
    }

    @Override
    public Page<AuctionItem> getAuctionItemsWithSuccessfulBidLessThan(Double amount, Pageable pageable) {
        return auctionItemDao.getAuctionItemsWithSuccessfulBidLessThan(amount, pageable);
    }
}
