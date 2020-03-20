package com.example.navigationdrawer.Adpater;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.navigationdrawer.R;
import com.example.navigationdrawer.Response.DataResponse;
import com.example.navigationdrawer.activities.DetailActivity;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private Context context;
    private List<DataResponse> data_list;

    public ListAdapter(Context context, List<DataResponse> data_list){
        this.context = context;
        this.data_list = data_list;

    }


    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListAdapter.ViewHolder viewHolder, int i) {
        final DataResponse dataResponse = data_list.get(i);
        viewHolder.name.setText(dataResponse.getName());

        viewHolder.address.setText(dataResponse.getAddress());

        String img_url = dataResponse.getPhoto_url();

        Glide.with(context).load(img_url).into(viewHolder.imageView);


        // set onClick to start DetailActivity.java
        viewHolder.cover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(DetailActivity.VENUE_NAME, dataResponse.getName());
                intent.putExtra(DetailActivity.VENUE_ADDRESS, dataResponse.getAddress());
                intent.putExtra(DetailActivity.VENUE_PHOTO_URL, dataResponse.getPhoto_url());
                intent.putExtra(DetailActivity.VENUE_LONG, dataResponse.getLongitude());
                intent.putExtra(DetailActivity.VENUE_LAT, dataResponse.getLatitude());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (data_list != null && !data_list.isEmpty()) {
            return data_list.size();
        }else{
            return 0;
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView address;
        private TextView name;
        private ImageView imageView;
        private ImageView bookmark;
        private DataResponse dataResponse;
        public View cover;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            address = (TextView) itemView.findViewById(R.id.address);
            imageView = (ImageView) itemView.findViewById(R.id.image);
//            bookmark = (ImageView) itemView.findViewById(R.id.bookmark);

            cover = itemView.findViewById(R.id.clickable_cover);

        }

    }
}
