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

/**
 * Created by Reem on 17,Nov,2018
 */

public class RestaurantsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.places_list);

        // Handling the Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setTitle(R.string.restaurants_title);
        actionbar.setHomeAsUpIndicator(R.drawable.baseline_arrow_back_ios_white_18);

        // Changing the statusbar color
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
        final ArrayList<ModernPlace> restaurants = new ArrayList<>();

        // Add Restaurants
        restaurants.add(new ModernPlace(getString(R.string.restaurant_one_name), 4.5,
                getString(R.string.restaurant_one_address), getString(R.string.restaurant_one_phone)));

        restaurants.add(new ModernPlace(getString(R.string.restaurant_two_name), 4.3,
                getString(R.string.restaurant_two_address), getString(R.string.restaurant_two_phone)));

        restaurants.add(new ModernPlace(getString(R.string.restaurant_three_name), 4.5,
                getString(R.string.restaurant_three_address), getString(R.string.restaurant_three_phone)));

        restaurants.add(new ModernPlace(getString(R.string.restaurant_four_name), 4.2,
                getString(R.string.restaurant_four_address), ""));

        restaurants.add(new ModernPlace(getString(R.string.restaurant_five_name), 4.4,
                getString(R.string.restaurant_five_address), getString(R.string.restaurant_five_phone)));

        restaurants.add(new ModernPlace(getString(R.string.restaurant_six_name), 4.4,
                getString(R.string.restaurant_six_address), getString(R.string.restaurant_five_phone)));

        restaurants.add(new ModernPlace(getString(R.string.restaurant_seven_name), 4.0,
                getString(R.string.restaurant_seven_address), getString(R.string.restaurant_seven_phone)));

        restaurants.add(new ModernPlace(getString(R.string.restaurant_eight_name), 3.7,
                getString(R.string.restaurant_eight_address), getString(R.string.restaurant_eight_phone)));

        // Create a ModernPlaceAdapter.
        ModernPlaceAdapter adapter = new ModernPlaceAdapter(this, restaurants, android.R.color.background_light);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
