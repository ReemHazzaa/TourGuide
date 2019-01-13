package customPlaceObjectsAndAdapters;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.reem.tourguide.R;

import java.util.ArrayList;

/**
 * Created by Reem on 16,Nov,2018
 */

public class ModernPlaceAdapter extends ArrayAdapter<ModernPlace> {

    /**
     * Resource ID for the background color for this list of places or elements
     */
    private int mColorResourceId;

    // Constructor to create a new ModernPlace object
    public ModernPlaceAdapter(Activity context, ArrayList<ModernPlace> modernPlaces, int colorResourceId) {
        super(context, 0, modernPlaces);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.modern_place_item, parent, false);
        }
        // Get the {@link ModernPlace} object located at this position in the list
        final ModernPlace currentModernPlace = getItem(position);

        TextView headerTextView = listItemView.findViewById(R.id.nameTextView);
        headerTextView.setText(currentModernPlace.getmPlaceName());

        TextView addressTextView = listItemView.findViewById(R.id.addressTextView);
        addressTextView.setText(currentModernPlace.getmPlaceAddress());

        TextView ratingTextView = listItemView.findViewById(R.id.ratingTextView);
        ratingTextView.setText(currentModernPlace.getmPlaceRating().toString());

        TextView locationTextView = listItemView.findViewById(R.id.locationTextView);
        String currentLocation = currentModernPlace.getmPlaceLocation();
        if (currentLocation != null && !currentLocation.isEmpty()) {
            locationTextView.setText(currentModernPlace.getmPlaceLocation());
        }

        TextView placeTypeTextView = listItemView.findViewById(R.id.placeTypeTextView);
        if (currentModernPlace.hasType()) {
            placeTypeTextView.setText(currentModernPlace.getmPlaceType());
        } else {
            placeTypeTextView.setVisibility(View.GONE);
        }

        TextView priceTextView = listItemView.findViewById(R.id.priceTextView);
        priceTextView.setText(String.valueOf(currentModernPlace.getmPlacePrice()));

        // nightPriceTextView
        // Make sure that all other irrelevant views are GONE if the place price is not provided
        TextView nightPriceTextView = listItemView.findViewById(R.id.nightPriceTextView);
        if (currentModernPlace.getmPlacePrice() == 0.0) {
            priceTextView.setVisibility(View.GONE);
            nightPriceTextView.setVisibility(View.GONE);
            locationTextView.setVisibility(View.GONE);
        }

        // placeImageView
        ImageView placeImageView = listItemView.findViewById(R.id.placeImageView);
        // Check if an image is provided for this place or not
        if (currentModernPlace.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            placeImageView.setImageResource(currentModernPlace.getmImageResourceId());

            // Make sure the view is visible
            placeImageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            placeImageView.setVisibility(View.GONE);
        }

        // PhoneButtonView
        LinearLayout placePhoneButton = listItemView.findViewById(R.id.placePhoneButton);

        // Check if a phone is provided for this place or not
        if (currentModernPlace.hasPhone()) {
            // Make sure the View is visible
            placePhoneButton.setVisibility(View.VISIBLE);

            // Make the call when the button is pressed
            placePhoneButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + currentModernPlace.getmPlacePhone()));
                    getContext().startActivity(intent);
                }
            });
        } else {
            // Otherwise hide the Button (set visibility to GONE)
            placePhoneButton.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View placeInfoContainer = listItemView.findViewById(R.id.placeInfoContainer);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the placeInfoContainer View
        placeInfoContainer.setBackgroundColor(color);

        // Return the whole list item so that it can be shown in the ListView
        return listItemView;
    }
}
