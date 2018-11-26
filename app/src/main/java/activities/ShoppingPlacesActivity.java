package activities;

import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import com.example.reem.tourguide.R;

import java.util.ArrayList;

import adapters.ModernPlace;
import adapters.ModernPlaceAdapter;

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
        final ArrayList<ModernPlace> shoppingPlaces = new ArrayList<>();

        shoppingPlaces.add(new ModernPlace("El Dukroury Mall",
                "Shopping mall in Luxor, Egypt",2.5,"Madinet Al Oqsor, Luxor, Luxor Governorate","0952365823"));
        shoppingPlaces.add(new ModernPlace("Habiba Gallery",
                "Shopping mall in Luxor, Egypt",4.5,"Luxor City, Luxor, Luxor Governoratee","01001242026"));
        shoppingPlaces.add(new ModernPlace("Fair Trade Center Luxor Center",
                "Art supply store in Luxor, Egypt",4.5,"Mabad Al Karnak, Luxor City, Luxor, Luxor Governorate","01000347900"));
        shoppingPlaces.add(new ModernPlace("Al-Rashed shops for shoes",
                "Shopping mall in Luxor, Egypt",4.1," El-Tayeb, Gazirat Al Awameyah, Luxor, Luxor Governorate",""));
        shoppingPlaces.add(new ModernPlace("Smart Shop","Electronics store in Luxor, Egypt",3.2,
                "أمتداد شارع علي بن أبي طالب الشهير بمضرب الأرز،, الشارع المجاور لكلية الفنون الجميلة، أمتداد نزلة الزناتي",
                "01001201913"));
        shoppingPlaces.add(new ModernPlace("Abbas Mansour Shopping Center","Shopping mall in Luxor, Egypt",
                4.4, "Luxor City, Luxor, Luxor Governorate",""));
        shoppingPlaces.add(new ModernPlace("Nnsensh Abaya Suwaiket","Shopping mall in Luxor, Egypt",
                0.0,"Al Masaken Al Shaabeya, Luxor City, Luxor, Luxor Governorate",""));
        shoppingPlaces.add(new ModernPlace("Kids Club","Shopping mall in Luxor, Egypt",3.9,
                "El-Tayeb, Gazirat Al Awameyah, Luxor, Luxor Governorate","01065044385"));


        // Create an {@link ModernPlaceAdapter}, whose data source is a list of {@link ModernPlace}s. The
        // adapter knows how to create list items for each item in the list.
        ModernPlaceAdapter adapter = new ModernPlaceAdapter(this, shoppingPlaces, R.color.wheat);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // modern_place_list_item file.
        ListView listView = findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ModernPlaceAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link ModernPlace} in the list.
        listView.setAdapter(adapter);
    }
}
