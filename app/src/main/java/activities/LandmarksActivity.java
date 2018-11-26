package activities;

import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import com.example.reem.tourguide.MainActivity;
import com.example.reem.tourguide.R;

import java.util.ArrayList;

import adapters.HistoricPlace;
import adapters.HistoricPlaceAdapter;

public class LandmarksActivity extends AppCompatActivity {

     private String landmarkSphinexesInfo = "The remains of these historic sphinxes make some interesting" +
            " monumental sights that provide good photo opportunities for enthusiastic tourists visiting Luxor.\n\n" +
            "Stretching about 3 km / 2 miles, the Avenue of the Sphinxes is the remains of a walkway that once connected" +
            " the temples of Luxor and Karnak, and was home to a number of human-headed sphinxes.\n\n" +
            "The walkway's main purpose was to facilitate the movement of the images of Amon, Mut and Khonsu which" +
            " were carried between the two temples in a once yearly festival.";
     private String landmarkMemnoInfo = "Located on the west bank of Luxor, about half a kilometre east of the Antiquities " +
            "Inspectorate, the Colossi of Memnon are two giant sandstone statues standing 23 metres / 75 feet high.\n\n" +
            "A temple originally stood on the same site and the Colossi were built as its guardians.\n\n" +
            "The characters of the statues are seated on huge granite plinths and these local landmarks look quite magnificent " +
            "looming over what is now a busy road.\n\n" +
            "Some other remains can be found in the same area, among which are two headless sphinxes.";
     private String valleyOfKingsLandmarkInfo = "While the Valley of the Kings is considerably " +
             "less grand than the Pyramids in terms of Egyptian funerary complexes,  it is still well worth a visit and" +
             " is amongst Luxor's most-visited tourist attractions.\n\n" +
             "The Valley of the Kings illustrates some aspects of the" +
             " Egyptian concept of the afterlife that the Pyramids do not.\n\n" +
             "Some 30 to 40 tombs are open for visitor exploration, although it would be highly ambitious to " +
             "expect to see so many and taking a look around five is usually sufficient for most tourists.\n\n" +
             "Among the more popular tombs are those of Ramesses IV, Ramesses IX, Merneptah and Ramesses VI.";
    private String deirElMadinaLandmarkInfo = "Otherwise known as the Artisan Village," +
            " Deir el-Medina is close to central Luxor and is the remains of an old Egyptian township that" +
            " was previously inhabited by various craftsmen following its founding by Tuthmose I.\n\n" +
            "The craftspeople who called this town home were responsible for decorating the tombs in the " +
            "Valley of the Kings.\n\n" +
            "Little or nothing is left of the original town except the stone walls which ran its perimeter " +
            "and marked out streets and houses.\n\nAttractions at Deir el-Medina include two tombs within the " +
            "town, which house the remains of some of the workers and also contain some interesting wall paintings.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.places_list);

        // Handling the Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setTitle(R.string.landmarks_title);
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

        // Create a list of HistoricPlaces
        final ArrayList<HistoricPlace> historicPlaces = new ArrayList<>();

        historicPlaces.add(new HistoricPlace("Avenue of the Sphinxes", landmarkSphinexesInfo,R.drawable.sphinxes));
        historicPlaces.add(new HistoricPlace("Colossi of Memnon", landmarkMemnoInfo,R.drawable.colossi_of_memnon));
        historicPlaces.add(new HistoricPlace("Valley of the kings",valleyOfKingsLandmarkInfo ,R.drawable.vally_of_kings));
        historicPlaces.add(new HistoricPlace("Deir el-Medina",deirElMadinaLandmarkInfo ,R.drawable.deir_elmedina));


        // Create an {@link HistoricPlaceAdapter}, whose data source is a list of {@link HistoricPlace}s. The
        // adapter knows how to create list items for each item in the list.
        HistoricPlaceAdapter adapter = new HistoricPlaceAdapter(this, historicPlaces, R.color.list_item_back);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // historic_place_list_item.xml mm file.
        ListView listView = findViewById(R.id.list);

        // Make the {@link ListView} use the {@link HistoricPlaceAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link HistoricPlace} in the list.
        listView.setAdapter(adapter);
    }
}
