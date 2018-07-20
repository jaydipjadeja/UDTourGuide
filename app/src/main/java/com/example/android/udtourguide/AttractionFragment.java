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
public class AttractionFragment extends Fragment {


    public AttractionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.category_list, container, false);

        //Add Attractions in ArrayList
        final ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category(getString(R.string.statue_name), getString(R.string.statue_addr), getString(R.string.statue_phone),R.drawable.statueofliberty,R.string.statue_desc));
        categories.add(new Category(getString(R.string.central_name), getString(R.string.central_addr), getString(R.string.central_phone),R.drawable.centralpark,R.string.central_desc));
        categories.add(new Category(getString(R.string.empire_name), getString(R.string.empire_addr), getString(R.string.empire_phone),R.drawable.empirestate,R.string.empire_desc));
        categories.add(new Category(getString(R.string.high_name), getString(R.string.high_addr), getString(R.string.high_phone),R.drawable.highline,R.string.high_desc));
        categories.add(new Category(getString(R.string.metro_name), getString(R.string.metro_addr), getString(R.string.metro_phone),R.drawable.metromuesum,R.string.metro_desc));
        categories.add(new Category(getString(R.string.grand_name), getString(R.string.grand_addr), getString(R.string.grand_phone),R.drawable.grandcentral,R.string.grand_desc));
        categories.add(new Category(getString(R.string.national_name), getString(R.string.national_addr), getString(R.string.national_phone),R.drawable.national,R.string.national_desc));

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
                intent.putExtra("title", "Attractions");

                startActivity(intent);

            }
        });

        return rootView;
    }

}
