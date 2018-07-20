package com.example.android.udtourguide;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CategoryAdapter extends ArrayAdapter<Category> {

    /**
     * This is custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param categories     A List of Category objects to display in a list
     */
    public CategoryAdapter(Activity context, ArrayList<Category> categories){
        super(context, 0, categories);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Category currentCategory = getItem(position);

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to imageView
        imageView.setImageResource(currentCategory.getmImageResourceId());

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.title_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        nameTextView.setText(currentCategory.getmPlaceName());

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView addressTextView = (TextView) listItemView.findViewById(R.id.address_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        addressTextView.setText(currentCategory.getmPlaceAddress());

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView contactTextView = (TextView) listItemView.findViewById(R.id.number_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        contactTextView.setText(currentCategory.getmContactNumber());

        return listItemView;
    }
}
