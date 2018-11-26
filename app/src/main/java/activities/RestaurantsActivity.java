package activities;

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

import adapters.ModernPlace;
import adapters.ModernPlaceAdapter;

/**
 * Created by Reem on 17,Nov,2018
 */

public class RestaurantsActivity extends AppCompatActivity {

    public String[] phones = {"01118799559","0952372386", " 0952361451", "", "01005747068", "0952359752","01270085503"," 01064326698"};

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
                window.setStatusBarColor(ContextCompat.getColor(this,R.color.colorPrimaryDark));
            }

            // Create a list of ModernPlaces
            final ArrayList<ModernPlace> restaurants = new ArrayList<>();

            restaurants.add(new ModernPlace("PIZZA ROMA.IT", 4.5, "Luxor Bridge, Gazirat Al Awameyah, Luxor Governorate", phones[0]));
            restaurants.add(new ModernPlace("Al - Sahaby Lane Restaurant", 4.3, " El Sahabi Street، Luxor City, Luxor Governorate", phones[1]));
            restaurants.add(new ModernPlace("The Lantern Room", 4.5," Al Rawda Al Sharifa, Gazirat Al Awameyah, Luxor Governorate",phones[2]));
            restaurants.add(new ModernPlace("1886 RESTAURANT", 4.2,"Corniche el Nile street, Luxor City, Luxor, Luxor Governorate 11432",phones[3]));
            restaurants.add(new ModernPlace("Aisha Restaurant",4.4 ,"Al Rawda Al Sharifa, Gazirat Al Awameyah, Luxor, Luxor Governorate",phones[4]));
            restaurants.add(new ModernPlace("Sofra", 4.4,"90 Mohamed Farid St, Luxor",phones[5]));
            restaurants.add(new ModernPlace("Sunrise Restaurant & Bar", 4.0, "Kaled Ebn Elwaled St, Luxor, Luxor Governorate",phones[6]));
            restaurants.add(new ModernPlace("Jewel Of The Nile Restaurant",3.7,"Rowda sharifa, Luxor, Egypt.\n"+"الروضة الشريفة، مدينة الأقصر.",phones[7]));

            // Create an {@link ModernPlaceAdapter}, whose data source is a list of {@link ModernPlace}s. The
            // adapter knows how to create list items for each item in the list.
            ModernPlaceAdapter adapter = new ModernPlaceAdapter(this, restaurants, R.color.wheat);

            // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
            // There should be a {@link ListView} with the view ID called list, which is declared in the
            // modern_place_list_item file.
            ListView listView = findViewById(R.id.list);

            // Make the {@link ListView} use the {@link ModernPlaceAdapter} we created above, so that the
            // {@link ListView} will display list items for each {@link ModernPlace} in the list.
            listView.setAdapter(adapter);

        }



}
