package com.atakmap.android.helloworld.plugin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.atakmap.android.dropdown.DropDownReceiver;
import com.atakmap.android.maps.MapView;

public class BloodhoundDashboardDropDown extends DropDownReceiver {
    private final View _view;
    private final MapView _mapView;

    public BloodhoundDashboardDropDown(MapView mapView, Context plugin, BloodhoundOrderManager orderManager) {
        super(mapView);
        this._mapView = mapView;
        _view = LayoutInflater.from(plugin).inflate(R.layout.bloodhound_dashboard, mapView, false);
        RecyclerView rv = _view.findViewById(R.id.bloodhoundOrdersRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(plugin));
        BloodhoundOrderAdapter adapter = new BloodhoundOrderAdapter(orderManager.getOrders(), orderManager::removeOrder);
        rv.setAdapter(adapter);
    }

    public void show() {
        // Show the dashboard as a drop-down
        showDropDown(_view, THREE_EIGHTHS_WIDTH, FULL_HEIGHT, FULL_WIDTH, THIRD_HEIGHT);
    }

    public View getView() {
        return _view;
    }

    @Override
    protected void disposeImpl() {
        // Clean up resources if needed
    }

    @Override
    public void onReceive(Context context, android.content.Intent intent) {
        // No broadcast handling needed for this drop-down
    }
}
