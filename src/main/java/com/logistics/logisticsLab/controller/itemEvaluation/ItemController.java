package com.logistics.logisticsLab.controller.itemEvaluation;

import java.util.List;

import com.logistics.logisticsLab.dto.itemEvaluation.ItemRequestDTO;
import com.logistics.logisticsLab.dto.itemEvaluation.ItemResponseDTO;
import com.logistics.logisticsLab.service.itemEvaluation.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/item")
@Log4j2
public class ItemController {

    @Autowired
    private ItemServiceImpl itemService;


    @PostMapping()
    public ResponseEntity<ItemResponseDTO> CreateItem(@RequestBody ItemRequestDTO item){
        try{
            ItemResponseDTO newItem =  itemService.addItem(item);
            log.info("Item Created",newItem);
            return new ResponseEntity<>(newItem,HttpStatus.CREATED);
            // URI location = new URI("/item/" + newItem.getItemId());
            // return ResponseEntity.created(location).body(newItem);
        }catch(Exception e){
            log.error("Item values mismatched");
            // return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<ItemResponseDTO> getItem(@PathVariable String itemId){
        try{
            ItemResponseDTO item = itemService.getItem(itemId);
            log.info("Item fetched with id :" + itemId,item);
            return new ResponseEntity<>(item,HttpStatus.FOUND);
        }catch(Exception e){
            log.error("Item values mismatched");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<ItemResponseDTO>> getAllItems(){
        try{
            List<ItemResponseDTO> items = itemService.getAllItems();
            log.info("All Items fetched");
            return new ResponseEntity<>(items,HttpStatus.FOUND);
        }catch(Exception e){
            log.error("No Items Present");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<ItemResponseDTO> deleteItem(@PathVariable String itemId){
        try{
            ItemResponseDTO item = itemService.removeItem(itemId);
            log.info("Item deleted with id :" + itemId,item);
            return new ResponseEntity<>(item,HttpStatus.OK);
        }catch(Exception e){
            log.error("Item values mismatched");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

