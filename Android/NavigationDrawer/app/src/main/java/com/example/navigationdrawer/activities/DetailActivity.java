package com.example.navigationdrawer.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.navigationdrawer.R;
import com.example.navigationdrawer.helper.Utils;
import com.example.navigationdrawer.model.Venue;
import com.example.navigationdrawer.sql.DatabaseHelper;

import java.util.HashSet;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import static com.example.navigationdrawer.activities.LoginActivity.databaseHelper;

public class DetailActivity extends AppCompatActivity {

    public static final String VENUE_NAME = "VENUE_NAME";
    public static final String VENUE_ADDRESS = "VENUE_ADDRESS";
    public static final String VENUE_PHOTO_URL = "VENUE_PHOTO_URL";
    public static final String VENUE_LONG = "VENUE_LONG";
    public static final String VENUE_LAT = "VENUE_LAT";

    private ImageView imageView;
    private ImageButton bookmarkButton;
    private TextView textView_address;
    private TextView textView_name;
    private boolean isBookmarkClicked;


    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_detail);

        isBookmarkClicked = false;

        // get venue information from ListAdapter
        Intent intent = getIntent();
        final String venueName = intent.getStringExtra(VENUE_NAME);
        final String venueAddress = intent.getStringExtra(VENUE_ADDRESS);
        final String venuePhotoUrl = intent.getStringExtra(VENUE_PHOTO_URL);
        final String venueLong = intent.getStringExtra(VENUE_LONG);
        final String venueLat = intent.getStringExtra(VENUE_LAT);
        final int userID = LoginActivity.userID;

        // initiate Detail Activity View
        imageView = findViewById(R.id.detail_image);
        bookmarkButton = findViewById(R.id.detail_bookmark);
        textView_address = findViewById(R.id.detail_address);
        textView_name = findViewById(R.id.detail_name);

        // load image from our server side
        //Glide.with(this).load(venuePhotoUrl).asBitmap().into(imageView);
        Glide.with(this).load(venuePhotoUrl).asBitmap().into(imageView);
        textView_name.setText(venueName);
        textView_address.setText(venueAddress);

        //get all bookmarks from BookMark table
        final HashSet<String> bookmarkedSet = databaseHelper.getBookMarksName(userID);

        // change icon when a venue is bookmarked

        if ( bookmarkedSet == null){
            bookmarkButton.setImageResource(R.drawable.baseline_favorite_border_black_18dp);
        }else {
            if (bookmarkedSet.contains(venueName)) {
                bookmarkButton.setImageResource(R.drawable.baseline_favorite_red_24dp);
                isBookmarkClicked = true;
            } else {
                bookmarkButton.setImageResource(R.drawable.baseline_favorite_border_black_18dp);
            }
        }

        bookmarkButton.bringToFront();

        // set on click to save venue in BookMark table or delete from BookMark table
        bookmarkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isBookmarkClicked){
                    // change image to Bitmap
                    final Bitmap venueImage = ((BitmapDrawable)imageView.getDrawable().getCurrent()).getBitmap();

                    databaseHelper.addVenue(new Venue(Utils.getBytes(venueImage), venueAddress, venueName, userID, venueLong, venueLat));
                    Toast.makeText(getApplicationContext(),"Bookmark added",Toast.LENGTH_SHORT).show();
                    bookmarkButton.setImageResource(R.drawable.baseline_favorite_red_24dp);
                    isBookmarkClicked=true;
                }else{
                    databaseHelper.deleteVenue(venueName);
                    Toast.makeText(getApplicationContext(),"Bookmark removed",Toast.LENGTH_SHORT).show();
                    bookmarkButton.setImageResource(R.drawable.baseline_favorite_border_black_24dp);
                    isBookmarkClicked = false;

                }

            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(DetailActivity.this);
                builder.setMessage("Open Google Maps?")
                        .setCancelable(true)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Uri gmmIntentUri = Uri.parse("google.navigation:q=" + venueLat + "," + venueLong);
                                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                                mapIntent.setPackage("com.google.android.apps.maps");
                                startActivity(mapIntent);

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                final AlertDialog alert = builder.create();
                alert.show();
            }
        });


    }
}
