package com.atakmap.android.helloworld.plugin;

import java.util.ArrayList;
import java.util.List;

public class BloodhoundOrderManager {
    private final List<BloodhoundOrder> orders = new ArrayList<>();

    public void addOrder(BloodhoundOrder order) {
        orders.add(order);
    }

    public void removeOrder(BloodhoundOrder order) {
        orders.remove(order);
    }

    public List<BloodhoundOrder> getOrders() {
        return orders;
    }

    public BloodhoundOrder findOrder(String mapItemTitle, String contact) {
        for (BloodhoundOrder order : orders) {
            if (order.getMapItemTitle().equals(mapItemTitle) && order.getContact().equals(contact)) {
                return order;
            }
        }
        return null;
    }
}

