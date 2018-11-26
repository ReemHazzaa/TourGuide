package activities;

import android.app.ActionBar;
import android.content.Context;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import com.example.reem.tourguide.MainActivity;
import com.example.reem.tourguide.R;

import java.util.ArrayList;

import adapters.HistoricPlace;
import adapters.HistoricPlaceAdapter;

public class TemplesActivity extends AppCompatActivity {

    private String templeKarnak = "Known as Ipet-isut " +
            "by the ancient Egyptians, the Temple of Karnak is in fact a whole city of " +
            "temples that were constructed over two millennia ago and were originally made " +
            "in tribute to the Theben triad of Amon, Mut and Khonsu.\n\n" +
            "Within easy reach of central Luxor, this entire ancient city covers some 200 acres / 120 hectares, with the " +
            "many attractions at the Amon enclosure alone covering a massive 60 acres / " +
            "36 hectares.\n\nThe biggest temple at the heart of the city is awesome and so big " +
            "that the cathedrals of Notre Dame, St. Peter's and Milan would be lost within its " +
            "spacious confines.\n\nThe 54,000 square-foot Hypostyle Hall has a total of 134 columns " +
            "and is hailed as the largest room within a religious building anywhere in the " +
            "world.";
    private String templeOfLuxor = "The Temple of Luxor was built largely " +
            "by King Ramesses II and King Amenhotep III " +
            "and was constructed with the intention of being the focal point of the city's most popular festival," +
            "known as the Festival of Opet.\n\nThis grand temple is a magnificent structure with many separate " +
            "sections, each of which was designed with a specific purpose in mind with regards to the festival.\n\n" +
            "Some of the most famous buildings and attractions include the Pylons, Court of Ramesses II," +
            " Mosque of Abu'l Haggag and the Court of Amenhotep II.";
    private String templeMerneptah = "The original Mortuary Temple of Merneptah was all but destroyed.\n\n" +
            "However it has been faithfully reconstructed and is now one of the newest sights of interest" +
            " on Luxor's West Bank.\n\nWhile many of the interior details (such as wall reliefs) that one would" +
            " expect to find in a temple of this nature are not evident, the construction offers a highly accurate" +
            " impression of the exterior and interior architectural features of a 19th Dynasty funerary compound.";
    private String templeSetti = "Luxor's Temple of the Seti 1 was once one of the biggest temples in Thebes and although " +
            "much of the original structure no longer remains, those parts that are still standing are certainly worth viewing.\n\n" +
            "The temple dates back to the 13th century and contains many interesting stone carvings with depictions that pay homage" +
            " to Amon, Mut and Khonsu.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.places_list);

        // Handling the Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setTitle(R.string.temples_title);
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

        // Create a list of Temples (HistoricPlaces)
        final ArrayList<HistoricPlace> historicPlaces = new ArrayList<>();

        historicPlaces.add(new HistoricPlace("Temple of Karnak",templeKarnak ,R.drawable.karnak_temple));
        historicPlaces.add(new HistoricPlace("Temple of Luxor",templeOfLuxor ,R.drawable.luxot_temple));
        historicPlaces.add(new HistoricPlace("Temple of The Setti1",templeSetti ,R.drawable.setti));
        historicPlaces.add(new HistoricPlace("Temple of Merneptah",templeMerneptah ,R.drawable.merenepath));

        // Create an {@link HistoricPlaceAdapter}, whose data source is a list of {@link HistoricPlace}s. The
        // adapter knows how to create list items for each item in the list.
        HistoricPlaceAdapter adapter = new HistoricPlaceAdapter(this, historicPlaces, R.color.list_item_back);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // historic_place_list_item.xml file.
        ListView listView = findViewById(R.id.list);

        // Make the {@link ListView} use the {@link HistoricPlaceAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link HistoricPlace} in the list.
        listView.setAdapter(adapter);

    }
}
