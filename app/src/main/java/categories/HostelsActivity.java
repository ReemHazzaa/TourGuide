package categories;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import com.example.reem.tourguide.R;

import java.util.ArrayList;

import customPlaceObjectsAndAdapters.ModernPlace;
import customPlaceObjectsAndAdapters.ModernPlaceAdapter;

public class HostelsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.places_list);

        // Handling the Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setTitle(R.string.hostels_title);
        actionbar.setHomeAsUpIndicator(R.drawable.baseline_arrow_back_ios_white_18);

        // Changing the status bar color
        Window window = this.getWindow();
        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        // Add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        // finally change the color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        }

        // Create a list of ModernPlaces
        final ArrayList<ModernPlace> hostels = new ArrayList<>();

        hostels.add(new ModernPlace(getString(R.string.hostel_one_name), 5.0,
                getString(R.string.hostel_one_address), getString(R.string.hostel_one_phone)));

        hostels.add(new ModernPlace(getString(R.string.hostel_two_name), 2.2,
                getString(R.string.hostel_two_address), getString(R.string.hostel_two_phone)));

        // Create a ModernPlaceAdapter.
        ModernPlaceAdapter adapter = new ModernPlaceAdapter(this, hostels, android.R.color.background_light);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
