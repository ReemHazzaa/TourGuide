package adapters;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.reem.tourguide.R;

import java.util.ArrayList;

/**
 * Created by Reem on 16,Nov,2018
 */

public class ModernPlaceAdapter extends ArrayAdapter<ModernPlace> {

    /** Resource ID for the background color for this list of places or elements */
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
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.modern_place_list_item, parent, false);
        }
        // Get the {@link ModernPlace} object located at this position in the list
        final ModernPlace currentModernPlace = getItem(position);

        // Find the TextView in the modern_place_list_item.xmlxml with the ID nameTextView
        TextView headerTextView =  listItemView.findViewById(R.id.nameTextView);
        // Get the place name from the current ModernPlace object and
        // set this text on the nameTextView
        headerTextView.setText(currentModernPlace.getmPlaceName());

        // Find the TextView in the modern_place_list_item.xml with the ID addressTextView
        TextView addressTextView =  listItemView.findViewById(R.id.addressTextView);
        // Get the place address from the current ModernPlace object and
        // set this text on the addressTextView
        addressTextView.setText(currentModernPlace.getmPlaceAddress());

        // Find the TextView in the modern_place_list_item.xml with the ID ratingTextView
        TextView ratingTextView =  listItemView.findViewById(R.id.ratingTextView);
        // Get the place rating value from the current ModernPlace object and
        // set this text on the ratingTextView
        ratingTextView.setText(currentModernPlace.getmPlaceRating().toString());

        // Find the TextView in the modern_place_list_item.xml with the ID locationTextView
        TextView locationTextView =  listItemView.findViewById(R.id.locationTextView);
        // Get the place location from the current ModernPlace object and
        // set this text on the locationTextView
        String currentLocation = currentModernPlace.getmPlaceLocation();
        if(currentLocation!= null && !currentLocation.isEmpty()) {
            locationTextView.setText(currentModernPlace.getmPlaceLocation());
        }

        // Find the TextView in the modern_place_list_item.xml with the ID placeTypeTextView
        TextView placeTypeTextView =  listItemView.findViewById(R.id.placeTypeTextView);
        // Get the place type from the current ModernPlace object and
        // set this text on the nameTextView
        if (currentModernPlace.hasType()) {
            placeTypeTextView.setText(currentModernPlace.getmPlaceType());
        } else {
            placeTypeTextView.setVisibility(View.GONE);
        }
        // Find the TextView in the modernPlace_list_item.xml with the ID priceTextView
        TextView priceTextView =  listItemView.findViewById(R.id.priceTextView);
        // Get the place price from the current ModernPlace object and
        // set this text on the priceTextView
        priceTextView.setText(String.valueOf(currentModernPlace.getmPlacePrice()));

        // nightPriceTextView
        // Make sure that all other irrelevant views are GONE if the place price is not provided
        TextView nightPriceTextView = listItemView.findViewById(R.id.nightPriceTextView);
        if (currentModernPlace.getmPlacePrice() == 0.0) {
            priceTextView.setVisibility(View.GONE);
            nightPriceTextView.setVisibility(View.GONE);
            locationTextView.setVisibility(View.GONE);
        }

        // ImageView
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
        ImageButton placePhoneButton = listItemView.findViewById(R.id.placePhoneButton);

        // Check if a phone is provided for this place or not
        if (currentModernPlace.hasPhone()){
            // Make sure the ImageButtonView is visible
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
            // Otherwise hide the ImageButton (set visibility to GONE)
            placePhoneButton.setVisibility(View.GONE);
        }


        // Set the theme color for the list item
        View placeInfoContainer = listItemView.findViewById(R.id.placeInfoContainer);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the placeInfoContainer View
        placeInfoContainer.setBackgroundColor(color);


        // Return the whole list item mm (containing 5 TextViews, 1 RatingBar & 1 ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
