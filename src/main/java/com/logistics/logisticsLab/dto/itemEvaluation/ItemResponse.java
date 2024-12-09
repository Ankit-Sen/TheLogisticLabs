package com.logistics.logisticsLab.dto.itemEvaluation;

import com.logistics.logisticsLab.model.itemEvaluation.ItemType;

import com.logistics.logisticsLab.model.itemEvaluation.Dimension;
import com.logistics.logisticsLab.model.itemEvaluation.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemResponse {
    private Long itemId;
    private String name;
    private ItemType itemType;
    private Dimension dimension;
    private boolean fragile;

    public ItemResponse(Item item){
        this.itemId=item.getItemId();
        this.itemType=item.getItemType();
        this.name=item.getName();
        // this.dimension=item.getDimension();
        this.fragile=item.getFragile();
    }
}
