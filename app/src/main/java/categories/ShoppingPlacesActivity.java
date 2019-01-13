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
 * Created by Reem on 18,Nov,2018
 */
public class ShoppingPlacesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.places_list);

        // Handling the Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setTitle(R.string.shopping_title);
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
        final ArrayList<ModernPlace> shoppingPlaces = new ArrayList<>();

        shoppingPlaces.add(new ModernPlace(getString(R.string.shop_one_name),
                getString(R.string.first_shop_type), 2.5,
                getString(R.string.shop_one_address),
                R.string.shop_one_phone));

        shoppingPlaces.add(new ModernPlace(getString(R.string.shop_two_name),
                getString(R.string.first_shop_type), 4.5,
                getString(R.string.shop_two_address),
                getString(R.string.shop_two_phone)));

        shoppingPlaces.add(new ModernPlace(getString(R.string.shop_three_name),
                getString(R.string.second_shop_type), 4.5,
                getString(R.string.shop_three_address),
                getString(R.string.shop_three_phone)));

        shoppingPlaces.add(new ModernPlace(getString(R.string.shop_four_name),
                getString(R.string.first_shop_type), 4.1,
                getString(R.string.shop_four_address),
                ""));

        shoppingPlaces.add(new ModernPlace(getString(R.string.shop_five_name),
                getString(R.string.third_shop_type), 3.2,
                getString(R.string.shop_five_address),
                getString(R.string.shop_five_phone)));

        shoppingPlaces.add(new ModernPlace(getString(R.string.shop_six_name),
                getString(R.string.first_shop_type), 4.4,
                getString(R.string.shop_six_address),
                ""));

        shoppingPlaces.add(new ModernPlace(getString(R.string.shop_seven_name),
                getString(R.string.first_shop_type), 0.0,
                getString(R.string.shop_seven_address),
                ""));

        shoppingPlaces.add(new ModernPlace(getString(R.string.shop_eight_name),
                getString(R.string.first_shop_type), 3.9,
                getString(R.string.shop_eight_address),
                getString(R.string.shop_eight_phone)));

        ModernPlaceAdapter adapter = new ModernPlaceAdapter(this, shoppingPlaces, android.R.color.background_light);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
