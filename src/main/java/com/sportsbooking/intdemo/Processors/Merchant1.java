package com.sportsbooking.intdemo.Processors;

import com.sportsbooking.intdemo.Modal.GameEvent;

import java.util.ArrayList;

public class Merchant1 implements MerchantOnboard {
    @Override
    public String getTenantId() {
        return "Merchant1";
    }

    @Override
    public String gameList() {
        GameEvent gameEvent = new GameEvent();
        ArrayList<GameEvent> gameEvents = new ArrayList<>();

        return null;
    }

    @Override
    public String getCapacity() {
        return null;
    }

    @Override
    public String isOccupied(String game, Integer id) {
        return null;
    }
}
