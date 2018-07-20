package com.example.android.udtourguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantFragment extends Fragment {


    public RestaurantFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.category_list, container, false);

        //Add Attractions in ArrayList
        final ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category(getString(R.string.bernadin_name), getString(R.string.bernadin_addr), getString(R.string.bernadin_phone),R.drawable.lebernadin,R.string.bernadin_desc));
        categories.add(new Category(getString(R.string.gramercy_name), getString(R.string.gramercy_addr), getString(R.string.gramercy_phone),R.drawable.gramercytavern,R.string.gramercy_desc));
        categories.add(new Category(getString(R.string.sodi_name), getString(R.string.sodi_addr), getString(R.string.sodi_phone),R.drawable.isodi,R.string.sodi_desc));
        categories.add(new Category(getString(R.string.perse_name), getString(R.string.perse_addr), getString(R.string.perse_phone),R.drawable.perse,R.string.perse_desc));
        categories.add(new Category(getString(R.string.daniel_name), getString(R.string.daniel_addr), getString(R.string.daniel_phone),R.drawable.daniel,R.string.daniel_desc));
        categories.add(new Category(getString(R.string.modern_name), getString(R.string.modern_addr), getString(R.string.modern_phone),R.drawable.themodern,R.string.modern_desc));
        categories.add(new Category(getString(R.string.eleven_name), getString(R.string.eleven_addr), getString(R.string.eleven_phone),R.drawable.eleven,R.string.eleven_desc));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        CategoryAdapter adapter = new CategoryAdapter(getActivity(), categories);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(getActivity(), DetailsActivity.class);

                Category item = categories.get(position);

                intent.putExtra("data", item);
                intent.putExtra("title", "Restaurant");

                startActivity(intent);

            }
        });

        return rootView;
    }

}
