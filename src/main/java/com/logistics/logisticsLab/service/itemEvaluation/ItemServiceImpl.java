package com.logistics.logisticsLab.service.itemEvaluation;
import java.util.List;
import java.util.stream.Collectors;

import com.logistics.logisticsLab.dto.itemEvaluation.ItemRequest;
import com.logistics.logisticsLab.dto.itemEvaluation.ItemResponse;
import com.logistics.logisticsLab.model.itemEvaluation.Dimension;
import com.logistics.logisticsLab.model.itemEvaluation.Driver;
import com.logistics.logisticsLab.model.itemEvaluation.Item;
import com.logistics.logisticsLab.model.itemEvaluation.ItemType;
import com.logistics.logisticsLab.repository.itemEvaluation.IItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ItemServiceImpl implements IItemService{

    @Autowired
    private IItemRepository itemRepository;

    public ItemResponse addItem(ItemRequest item) {
        Dimension dimension = new Dimension(item.getHeight(),item.getLength(),item.getWidth(),item.getWeight());
        Item newItem = new Item(item.getName(),ItemType.valueOf(item.getItemType()),"dimension");
        ItemType type = ItemType.valueOf(item.getItemType());
        newItem.setFragile(isFragile(type));
        Item itemResponse = itemRepository.save(newItem);
        return new ItemResponse(itemResponse);
    }

    public ItemResponse getItem(Long itemId) {
        Item item = itemRepository.findById(itemId).orElseThrow(() -> new RuntimeException("No such Item exists"));
        return new ItemResponse(item);
    }

    public List<ItemResponse> getAllItems() {
        List<Item> items = (List<Item>) itemRepository.findAll();
        if(items.size()!=0)
            return items.stream().map(item -> new ItemResponse(item)).collect(Collectors.toList());
        else
            throw new RuntimeException("List is Empty");
    }

    public ItemResponse removeItem(Long itemId) {
        Item item = itemRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Item does not exist"));
        itemRepository.deleteById(itemId);
        return new ItemResponse(item);
    }

    private boolean isFragile(ItemType type){
        return switch (type) {
            case GLASS, MARBLE -> true;
            default -> false;
        };
    }

    public boolean isFragile(String  type){
        return isFragile(ItemType.valueOf(type));
    }



    public String getDriverClassification(Item item){
        // if((item.getDimension().getWeight() < 2000) && (item.getDimension().getVolume() < 2000))
        //     return String.valueOf(Driver.CLASS1);
        // else if((item.getDimension().getWeight() < 5000) && (item.getDimension().getVolume() < 5000))
        //     return String.valueOf(Driver.CLASS2);
        // else
        //     return String.valueOf(Driver.CLASS3);
        return String.valueOf(Driver.CLASS3);
    }

}



// User [country=COUNTRY_USA, language=LANGUAGE_ENGLISH, userId=Anand]updated successfully.
// User [country=COUNTRY_INDIA, language=LANGUAGE_SPANISH, userId=Sabina]updated successfully.
// User [country=COUNTRY_USA, language=LANGUAGE_SPANISH, userId=Anand]updated successfully.
// User [country=COUNTRY_INDIA, language=LANGUAGE_HINDI, userId=Sabina]updated successfully.
// User [country=COUNTRY_INDIA, language=LANGUAGE_ENGLISH, userId=Anupama]updated successfully.

