package com.sportsbooking.intdemo.Processors;
import lombok.Data;

import java.util.List;
import java.util.Map;

public interface MerchantOnboard {
    String getTenantId();

    String gameList();

    String getCapacity();

    String isOccupied(String game, Integer id);
}
