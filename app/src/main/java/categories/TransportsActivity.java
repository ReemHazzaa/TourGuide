package categories;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import com.example.reem.tourguide.R;

import java.util.ArrayList;

import customPlaceObjectsAndAdapters.ModernPlace;
import customPlaceObjectsAndAdapters.ModernPlaceAdapter;

public class TransportsActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.places_list);

        // Handling the Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setTitle(R.string.transports_title);
        actionbar.setHomeAsUpIndicator(R.drawable.baseline_arrow_back_ios_white_18);

        // Changing the status bar color
        Window window = this.getWindow();
        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        // finally change the color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        }

        // Create a list of ModernPlaces
        final ArrayList<ModernPlace> transports = new ArrayList<>();

        transports.add(new ModernPlace(getString(R.string.transport_one_name), getString(R.string.transport_one_type),
                3.0, getString(R.string.transport_one_address), getString(R.string.transport_one_phone)));

        transports.add(new ModernPlace(getString(R.string.transport_two_name), getString(R.string.transport_two_type),
                4.1, getString(R.string.transport_two_address), getString(R.string.transport_two_phone)));

        transports.add(new ModernPlace(getString(R.string.transport_three_name), getString(R.string.transport_three_type),
                4.8, getString(R.string.transport_three_address), getString(R.string.transport_three_phone)));

        transports.add(new ModernPlace(getString(R.string.transport_four_name), getString(R.string.transport_four_type),
                3.7, getString(R.string.transport_four_address), ""));

        ModernPlaceAdapter adapter = new ModernPlaceAdapter(this, transports, android.R.color.background_light);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
