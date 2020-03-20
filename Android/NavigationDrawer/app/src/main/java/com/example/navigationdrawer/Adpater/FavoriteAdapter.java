package com.example.navigationdrawer.Adpater;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.navigationdrawer.R;
import com.example.navigationdrawer.Response.DataResponse;
import com.example.navigationdrawer.activities.DetailActivity;
import com.example.navigationdrawer.activities.HomeActivity;
import com.example.navigationdrawer.helper.Utils;
import com.example.navigationdrawer.model.Venue;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {

    private Context context;
    private List<Venue> data_list;

    public FavoriteAdapter(Context context, List<Venue> data_list){
        this.context = context;
        this.data_list = data_list;

    }


    @NonNull
    @Override
    public FavoriteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new FavoriteAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final FavoriteAdapter.ViewHolder viewHolder, int i) {
        final Venue venue = data_list.get(i);
        viewHolder.name.setText(venue.getName());

        viewHolder.address.setText(venue.getAddress());

        byte[] image = venue.getImage();

        viewHolder.imageView.setImageBitmap(Utils.getImage(image));

        viewHolder.cover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Open Google Maps?")
                        .setCancelable(true)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Uri gmmIntentUri = Uri.parse("google.navigation:q=" + venue.getAddress());
                                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                                mapIntent.setPackage("com.google.android.apps.maps");
                                context.startActivity(mapIntent);

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
//        viewHolder.bookmark.setImageResource(R.drawable.baseline_favorite_red_24dp);


        // set onClick to start DetailActivity.java
//        viewHolder.cover.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, DetailActivity.class);
//                intent.putExtra(DetailActivity.VENUE_NAME, venue.getName());
//                intent.putExtra(DetailActivity.VENUE_ADDRESS, venue.getAddress());
//                intent.putExtra(DetailActivity.VENUE_PHOTO_URL, venue.getPhoto_url());
//                context.startActivity(intent);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        if (data_list != null) {
            return data_list.size();
        }else {
            return 0;
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView address;
        private TextView name;
        private ImageView imageView;
        private ImageView bookmark;
        public View cover;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            address = (TextView) itemView.findViewById(R.id.address);
            imageView = (ImageView) itemView.findViewById(R.id.image);
            cover = itemView.findViewById(R.id.clickable_cover);
//            bookmark = (ImageView) itemView.findViewById(R.id.bookmark);

//            cover = itemView.findViewById(R.id.clickable_cover);

        }

    }
}
