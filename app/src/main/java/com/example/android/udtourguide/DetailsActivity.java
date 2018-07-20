package com.example.android.udtourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        if (!getIntent().hasExtra("data")) return;
        if (getIntent().hasExtra("title")) setTitle(getIntent().getStringExtra("title"));

        final Category category = (Category) getIntent().getSerializableExtra("data");


        ImageView descImage = findViewById(R.id.attraction_image);
        descImage.setImageResource(category.getmImageResourceId());

        TextView descName = findViewById(R.id.desc_name);
        descName.setText(category.getmPlaceName());

        TextView descAddress = findViewById(R.id.des_address);
        descAddress.setText(category.getmPlaceAddress());

        TextView descPhone = findViewById(R.id.des_phone);
        descPhone.setText(category.getmContactNumber());

        TextView description = findViewById(R.id.description);
        description.setText(category.getmDescriptionId());

        Button map = findViewById(R.id.map_direction);
        map.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = category.getmPlaceAddress();
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + name);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                // mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }

            }
        });

        Button call = findViewById(R.id.call_phone);
        call.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = category.getmContactNumber();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + number));
                startActivity(intent);
            }
        });
    }
}
