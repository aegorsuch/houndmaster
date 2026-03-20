
package com.atakmap.android.helloworld;

import com.atakmap.android.helloworld.plugin.R;
import androidx.fragment.app.Fragment;
import com.atakmap.android.user.icon.*;
import com.atakmap.android.maps.Marker;
import com.atakmap.android.maps.MapItem;

 import android.view.View;
 import android.os.Bundle;
 import android.view.LayoutInflater;
 import android.view.ViewGroup;
 import android.content.Context;
 import com.atakmap.android.maps.MapView;

import com.atakmap.coremap.maps.coords.GeoPointMetaData;

public class PluginIconPallet implements IconPallet {

    static Context pContext = null;
    static MapView mapView = null;

    public PluginIconPallet(Context pContext) {
        PluginIconPallet.pContext = pContext;
        // MapView will be set later when available
    }

    @Override
    public String getTitle() {
        return "HelloPallet";
    }

    @Override
    public String getUid() {
        return "HELLO_PLUGIN-55AE-33GF-3333-21112";
    }

    @Override
    public Fragment getFragment() {
        return new DashboardLauncherFragment();
    }

    @Override
    public String toString() {
        return "HelloPallet";
    }

    /**
     * Actual function to place the point.     Does not need to be implemented
     * if the fragment handles the user interactions.
     */
    @Override
    public MapItem getPointPlacedIntent(GeoPointMetaData point, String uid) {
        // logic that creates the point //
        return new Marker(point, uid);
    }

    @Override
    public void select(int resId) {
    }

    @Override
    public void clearSelection(boolean bPauseListener) {
        // needs to interact with the custom fragment to do that
        // fooFragment should impl clearSelection;
    }

    @Override
    public void refresh() {
        // needs to interact with the custom fragment to do that 
        // fooFragment should impl refresh;
    }

    static public class DashboardLauncherFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            if (mapView != null && pContext != null) {
                com.atakmap.android.helloworld.plugin.BloodhoundDashboardDropDown.showDashboard(mapView, pContext);
            }
            // Return a minimal FrameLayout to suppress default hints
            return new android.widget.FrameLayout(requireContext());
        }
    }
}
