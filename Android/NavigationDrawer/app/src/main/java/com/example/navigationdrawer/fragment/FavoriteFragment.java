package com.example.navigationdrawer.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.navigationdrawer.Adpater.FavoriteAdapter;
import com.example.navigationdrawer.Adpater.ListAdapter;
import com.example.navigationdrawer.R;
import com.example.navigationdrawer.Response.DataResponse;
import com.example.navigationdrawer.model.Venue;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.navigationdrawer.activities.LoginActivity.databaseHelper;
import static com.example.navigationdrawer.activities.LoginActivity.userID;

public class FavoriteFragment extends Fragment {

    private RecyclerView recyclerView;
    private ListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view_favorite);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();
        return view;
    }

    private void updateUI(){
        List<Venue> items = databaseHelper.getBookMarks(userID);
        recyclerView.setAdapter(new FavoriteAdapter(getContext(), items));
        recyclerView.smoothScrollToPosition(0);
    }
}
