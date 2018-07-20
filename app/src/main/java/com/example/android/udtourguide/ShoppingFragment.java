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
public class ShoppingFragment extends Fragment {


    public ShoppingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.category_list, container, false);

        //Add Attractions in ArrayList
        final ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category(getString(R.string.columbus_name), getString(R.string.columbus_addr), getString(R.string.columbus_phone),R.drawable.columbus,R.string.columbus_desc));
        categories.add(new Category(getString(R.string.westfield_name), getString(R.string.westfield_addr), getString(R.string.westfield_phone),R.drawable.westfield,R.string.westfield_desc));
        categories.add(new Category(getString(R.string.staten_name), getString(R.string.staten_addr), getString(R.string.staten_phone),R.drawable.statenmall,R.string.staten_desc));
        categories.add(new Category(getString(R.string.brookfield_name), getString(R.string.brookfield_addr), getString(R.string.brookfield_phone),R.drawable.brookfield,R.string.brookfield_desc));
        categories.add(new Category(getString(R.string.bay_name), getString(R.string.bay_addr), getString(R.string.bay_phone),R.drawable.bayplaza,R.string.bay_desc));
        categories.add(new Category(getString(R.string.atlantic_name), getString(R.string.atlantic_addr), getString(R.string.atlantic_phone),R.drawable.atlantic,R.string.atlantic_desc));

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
                intent.putExtra("title", "Shopping");

                startActivity(intent);

            }
        });

        return rootView;
    }

}
