package com.logistics.logisticsLab.service.fuelCalculation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IRiderService {

    String filterRider(List<String> Rlist);
    public HashMap<String, Integer> sortByValue(Map<String, Integer> hm);
}