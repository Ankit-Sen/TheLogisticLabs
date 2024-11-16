package com.logistics.logisticsLab.model.itemEvaluation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private String itemId;
    private String name;
    private ItemType itemType;
    private Dimension dimension;
    private boolean fragile;

    public Item(String itemId,Item item){
        this.itemId=itemId;
        this.itemType=item.getItemType();
        this.name=item.getName();
        this.dimension=item.getDimension();
        this.fragile=item.getFragile();
    }

    public Item(String name, ItemType itemType, Dimension dimension){
        this.itemType=itemType;
        this.name=name;
        this.dimension=dimension;
    }

    public boolean getFragile(){
        return this.fragile;
    }
}
