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

public class TemplesActivity extends AppCompatActivity {

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

        // Changing the status bar color
        Window window = this.getWindow();
        // Clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        // Add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        // Change the color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        }

        // Create a list of Temples (HistoricPlaces)
        final ArrayList<HistoricPlace> historicPlaces = new ArrayList<>();

        historicPlaces.add(new HistoricPlace(getString(R.string.karnak_header), getString(R.string.karnak_info), R.drawable.karnak_temple));
        historicPlaces.add(new HistoricPlace(getString(R.string.luxor_header), getString(R.string.luxor_info), R.drawable.luxot_temple));
        historicPlaces.add(new HistoricPlace(getString(R.string.setti_header), getString(R.string.setti_info), R.drawable.merenepath));
        historicPlaces.add(new HistoricPlace(getString(R.string.merneptah_header), getString(R.string.merneptah_info), R.drawable.karnak_temple));

        // Create a HistoricPlaceAdapter
        HistoricPlaceAdapter adapter = new HistoricPlaceAdapter(this, historicPlaces, R.color.historic_list_item_back);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
