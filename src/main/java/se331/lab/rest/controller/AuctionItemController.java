package se331.lab.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se331.lab.rest.entity.AuctionItem;
import se331.lab.rest.service.AuctionItemService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auction-item")
public class AuctionItemController {
    final AuctionItemService auctionItemService;

    @GetMapping
    public ResponseEntity<?> getAuctionItems(
            @RequestParam(value = "_limit", required = false) Integer perPage,
            @RequestParam(value = "_page", required = false) Integer page,
            @RequestParam(value = "_description", required = false) Integer description,
            @RequestParam(value = "_type", required = false) Integer type
    ) {
        perPage = perPage == null ? 5 : perPage;
        page = page == null ? 1 : page;

        Page<AuctionItem> auctionItemPage;
        if (description == null && type == null) {
            auctionItemPage = auctionItemService.getAuctionItems(PageRequest.of(page - 1, perPage));
        } else {
            auctionItemPage = auctionItemService.searchAuctionItems(description, type, PageRequest.of(page - 1, perPage));
        }
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("x-total-count", String.valueOf(auctionItemPage.getTotalElements()));
        return new ResponseEntity<>(auctionItemPage.getContent(), responseHeaders, HttpStatus.OK);
    }
}
