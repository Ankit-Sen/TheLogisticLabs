package com.logistics.logisticsLab.model.itemEvaluation;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;
    private String name;
    private ItemType itemType;
    // @Embedded
    private String dimension;
    private boolean fragile;

//    public Item(String itemId,Item item){
//        this.itemId=itemId;
//        this.itemType=item.getItemType();
//        this.name=item.getName();
//        this.dimension=item.getDimension();
//        this.fragile=item.getFragile();
//    }

    public Item(String name, ItemType itemType, String dimension){
        this.itemType=itemType;
        this.name=name;
        this.dimension=dimension;
    }

    public boolean getFragile() {
        return this.fragile;
    }
}
