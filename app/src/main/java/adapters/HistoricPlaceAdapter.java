package adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.reem.tourguide.R;

import java.util.ArrayList;

/**
 * Created by Reem on 15,Nov,2018
 */

public class HistoricPlaceAdapter extends ArrayAdapter<HistoricPlace> {
    /** Resource ID for the background color for this list of places or elements */
    private int mColorResourceId;

    // Constructor to create a new place object
    public HistoricPlaceAdapter(Activity context, ArrayList<HistoricPlace> historicPlaces, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an image, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, historicPlaces);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.historic_place_list_item, parent, false);
        }
        // Get the {@link HistoricPlace} object located at this position in the list
        HistoricPlace currentHistoricPlace = getItem(position);

        // Find the TextView in the historic_place_list_itemlist_item.xml mm with the ID headerTextView
        TextView headerTextView =  listItemView.findViewById(R.id.headerTextView);
        // Get the place header from the current HistoricPlace object and
        // set this text on the headerTextView
        headerTextView.setText(currentHistoricPlace.getmPlaceHeader());

        // Find the TextView in the historic_place_list_item.xml_item.xml mm with the ID headerTextView
        TextView infoTextView =  listItemView.findViewById(R.id.infoTextView);
        // Get the place info from the current HistoricPlace object and
        // set this text on the infoTextView
        infoTextView.setText(currentHistoricPlace.getmPlaceInfo());


        // ImageView
        ImageView placeImageView = listItemView.findViewById(R.id.placeImageView);
        // Check if an image is provided for this place or not
        if (currentHistoricPlace.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            placeImageView.setImageResource(currentHistoricPlace.getmImageResourceId());

            // Make sure the view is visible
            placeImageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            placeImageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View placeInfoContainer = listItemView.findViewById(R.id.placeInfoContainer);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the placeInfoContainer View
        placeInfoContainer.setBackgroundColor(color);


        // Return the whole list item mm (containing 2 TextViews & 1 ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

}
