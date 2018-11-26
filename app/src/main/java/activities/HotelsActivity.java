package activities;

import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import adapters.ModernPlace;
import adapters.ModernPlaceAdapter;

import com.example.reem.tourguide.MainActivity;
import com.example.reem.tourguide.R;

import java.util.ArrayList;

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
        final ArrayList<ModernPlace> hotels = new ArrayList<>();

        hotels.add(new ModernPlace("Pavillon Winter Luxor",
                "Cornish el Nile st, Luxor City Center, Luxor, Egypt",
                8.7,
                "7.47 km from Luxor international airport.",
                63));
        hotels.add(new ModernPlace("Happy Land Luxor",
                "El Kamar Street from El-madina El-monawara Street, Luxor City Center, Luxor, Egypt.",
                9.1,
                "7.33 km from Luxor international airport.",
                8));
        hotels.add(new ModernPlace("Sofitel Winter Palace Luxor",
                "Corniche el Nile street, Luxor City Center, Luxor",
                9.3,
                "7.55 km from Luxor international airport.",
                111, R.drawable.hotel_one));
        hotels.add(new ModernPlace("Steigenberger Nile Palace",
                "Khaled Ben El Walid Street, Luxor City Center, Luxor, Egypt.",
                8.1,
                "7.47 km from Luxor international airport.",
                86));
        hotels.add(new ModernPlace("Iberotel Luxor",
                "Khaled Ibn El Walid Street, P.O.Box (28), Luxor City Center, Luxor, Egypt.",
                7.8,
                "7.68 km from Luxor international airport.",
                27));


        // Create an {@link ModernPlaceAdapter}, whose data source is a list of {@link ModernPlace}s. The
        // adapter knows how to create list items for each item in the list.
        ModernPlaceAdapter adapter = new ModernPlaceAdapter(this, hotels, R.color.sandy_brown);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // modern_place_list_item file.
        ListView listView = findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ModernPlaceAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link ModernPlace} in the list.
        listView.setAdapter(adapter);
    }

}
