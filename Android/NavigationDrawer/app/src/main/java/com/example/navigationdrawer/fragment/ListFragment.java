package com.example.navigationdrawer.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.navigationdrawer.APIClient.ApiClient;
import com.example.navigationdrawer.APIClient.ApiInterface;
import com.example.navigationdrawer.Adpater.ListAdapter;
import com.example.navigationdrawer.R;
import com.example.navigationdrawer.Response.DataResponse;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.navigationdrawer.activities.LoginActivity.userID;

public class ListFragment extends Fragment {

    private RecyclerView recyclerView;
    private ListAdapter adapter;
    private List<DataResponse> items;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        items = null;
        adapter = new ListAdapter(getContext(), items);
        recyclerView.setAdapter(adapter);

        updateUI();


        return view;
    }

    private void updateUI(){
        ApiInterface apiService = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<DataResponse>> call = apiService.getPlaces();
        call.enqueue(new Callback<List<DataResponse>>() {
            @Override
            public void onResponse(Call<List<DataResponse>> call, Response<List<DataResponse>> response) {
                items = response.body();
//                adapter = new ListAdapter(getContext(), items);
//                recyclerView.setAdapter(adapter);
                adapter = new ListAdapter(getContext(), items);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                recyclerView.smoothScrollToPosition(0);
            }

            @Override
            public void onFailure(Call<List<DataResponse>> call, Throwable t) {
                Log.d("Error", t.getMessage());
                Toast.makeText(getContext(), "Error Fetching Data", Toast.LENGTH_LONG).show();
            }
        });
    }


}
