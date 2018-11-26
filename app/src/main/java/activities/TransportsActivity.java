package activities;


import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import adapters.ModernPlace;
import adapters.ModernPlaceAdapter;

import com.example.reem.tourguide.R;

import java.util.ArrayList;

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
        final ArrayList<ModernPlace> transports = new ArrayList<>();

        transports.add(new ModernPlace("Go Bus", "Transportation service in Luxor, Egypt" ,3.7,
        "Luxor City, Luxor, Luxor Governorate", ""));

        transports.add(new ModernPlace("Upper Egypt For Transport & Tourism",3.0,
                "Mostashfa el Homeyat st.، Luxor City, Luxor, Luxor Governorate","0952514005"));

        transports.add(new ModernPlace("Luxor International Airport","Airport in Egypt",4.1,
                "Monshaat Al Amari, Luxor, Luxor Governorate","0952324455"));

        transports.add(new ModernPlace("Qatar Airways","Airline in Luxor, Egypt",4.8,
                "Khaled Ibn Al Walid, Gazirat Al Awameyah, Luxor, Luxor Governorate","0952360000"));

        // Create an {@link ModernPlaceAdapter}, whose data source is a list of {@link ModernPlace}s. The
        // adapter knows how to create list items for each item in the list.
        ModernPlaceAdapter adapter = new ModernPlaceAdapter(this, transports, R.color.bisque);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // modern_place_list_item file.
        ListView listView = findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ModernPlaceAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link ModernPlace} in the list.
        listView.setAdapter(adapter);
    }
}
