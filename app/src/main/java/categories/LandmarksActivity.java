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

import customPlaceObjectsAndAdapters.HistoricPlace;
import customPlaceObjectsAndAdapters.HistoricPlaceAdapter;

public class LandmarksActivity extends AppCompatActivity {

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

        // Create a list of HistoricPlaces (Landmarks)
        final ArrayList<HistoricPlace> historicPlaces = new ArrayList<>();

        // Add HistoricPlace(s) to the historicPlaces ArrayList
        historicPlaces.add(new HistoricPlace(getString(R.string.sphinxes_header), getString(R.string.sphinxes_info), R.drawable.sphinxes));
        historicPlaces.add(new HistoricPlace(getString(R.string.memnon_header), getString(R.string.memnon_info), R.drawable.colossi_of_memnon));
        historicPlaces.add(new HistoricPlace(getString(R.string.kings_valley_header), getString(R.string.kings_valley_info), R.drawable.vally_of_kings));
        historicPlaces.add(new HistoricPlace(getString(R.string.deir_medina_header), getString(R.string.deir_medina_info), R.drawable.deir_elmedina));

        HistoricPlaceAdapter adapter = new HistoricPlaceAdapter(this, historicPlaces, R.color.historic_list_item_back);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
