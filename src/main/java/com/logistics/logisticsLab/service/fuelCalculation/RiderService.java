package com.logistics.logisticsLab.service.fuelCalculation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.logistics.logisticsLab.service.GenericAppEntity;
import org.springframework.stereotype.Service;

@Service
public class RiderService implements IRiderService{
    @Autowired
    GenericAppEntity genAppEntity;

    public String filterRider(List<String> Rlist)
    {
        Map<String, Integer> hm = new HashMap<>();
        List<Integer> order_LIST =new ArrayList<Integer>();
        List<String> rider_ID_LIST =genAppEntity.getRiderPool();
        for (int i = 0; i < rider_ID_LIST.size(); i++) {
            order_LIST.add(genAppEntity.getTripNum(rider_ID_LIST.get(i)));
        }
        for (int i = 0; i < rider_ID_LIST.size(); i++) {
            hm.put(rider_ID_LIST.get(i), order_LIST.get(i));
        }
        Map<String, Integer> result = sortByValue(hm);
        String firstKey = result.keySet().iterator().next();

        return firstKey;
    }



//    public HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
//        return null;
//    }
@Override
public LinkedHashMap<String, Integer> sortByValue(Map<String, Integer> hm) {
    // Create a list from elements of the map
    List<Map.Entry<String, Integer>> list = new LinkedList<>(hm.entrySet());

    // Sort the list using a lambda expression for clarity
    list.sort(Map.Entry.comparingByValue());

    // Create a LinkedHashMap to maintain the sorted order
    LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
    for (Map.Entry<String, Integer> entry : list) {
        sortedMap.put(entry.getKey(), entry.getValue());
    }

    return sortedMap;
}

}

