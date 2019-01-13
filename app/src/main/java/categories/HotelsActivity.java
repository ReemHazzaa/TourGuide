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

public class HotelsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.places_list);

        // Handling the Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setTitle(R.string.hotels_title);
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

        // Create a list of ModernPlace(s)
        final ArrayList<ModernPlace> hotels = new ArrayList<>();

        hotels.add(new ModernPlace(getString(R.string.hotel_one_name),
                getString(R.string.hotel_one_address),
                8.7,
                getString(R.string.hotel_one_location),
                63));

        hotels.add(new ModernPlace(getString(R.string.hotel_two_name),
                getString(R.string.hotel_two_address),
                9.1,
                getString(R.string.hotel_two_location),
                8));

        hotels.add(new ModernPlace(getString(R.string.hotel_three_name),
                getString(R.string.hotel_three_address),
                9.3,
                getString(R.string.hotel_three_location),
                111));
        hotels.add(new ModernPlace(getString(R.string.hotel_four_name),
                getString(R.string.hotel_four_address),
                8.1,
                getString(R.string.hotel_four_location),
                86));
        hotels.add(new ModernPlace(getString(R.string.hotel_five_name),
                getString(R.string.hotel_five_address),
                7.8,
                getString(R.string.hotel_five_location),
                27));

        ModernPlaceAdapter adapter = new ModernPlaceAdapter(this, hotels, android.R.color.background_light);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
