package se331.lab.rest.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import se331.lab.rest.entity.AuctionItem;
import se331.lab.rest.entity.AuctionItemDTO;

import java.util.List;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class); // Create a static instance

    AuctionItemDTO toAuctionItemDTO(AuctionItem auctionItem);
    List<AuctionItemDTO> toAuctionItemDTOs(List<AuctionItem> auctionItems);
    AuctionItem toAuctionItem(AuctionItemDTO auctionItemDTO);
}
