package com.example.navigationdrawer.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.navigationdrawer.R;
import com.example.navigationdrawer.activities.HomeActivity;
import com.example.navigationdrawer.test.MapActivity;
import com.example.navigationdrawer.test.test;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SearchFragment extends Fragment {

    EditText location;
    EditText type;
    Button search;
    Button btnmap;

    String city;
    String state;

    private static final String TAG = "SearchFragment";
    private static final int ERROR_DIALOG_REQUEST = 9001;

    private static final String ARG_CITY = "city";
    private static final String ARG_STATE = "state";

    public static SearchFragment newInstance(String city, String state){
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CITY, city);
        args.putString(ARG_STATE, state);
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_search, container, false);

        if (getArguments() != null){
            city = getArguments().getString(ARG_CITY);
            state = getArguments().getString(ARG_STATE);
        }

        if(isServiceOK()){
            init(view);
        }

        return view;
    }

    private void init(final View view){

        location = view.findViewById(R.id.location);
        type = view.findViewById(R.id.type);
        search = view.findViewById(R.id.search_button);
        btnmap = view.findViewById(R.id.btnMap);

        if (!TextUtils.isEmpty(city) && !TextUtils.isEmpty(state)){
            location.setText(city + " " + state);
        }

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String location_input = location.getText().toString();
                String type_input = type.getText().toString();

                if(!TextUtils.isEmpty(location_input) && !TextUtils.isEmpty(type_input)){

                    //start searchListFragment
                    SearchListFragment searchListFragment = SearchListFragment.newInstance(location_input, type_input);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, searchListFragment)
                            .commit();

                }else{
                    Snackbar.make(view, "Please enter location and type", Snackbar.LENGTH_LONG).show();
                }
            }
        });

        btnmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MapFragment()).commit();
            }
        });
    }

    public boolean isServiceOK(){
        Log.d(TAG, "isServicesOK: checking google services version");

        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(getActivity());

        if(available == ConnectionResult.SUCCESS) {
            Log.d(TAG, "isServicesOK: Google Play Services is working");
            return true;
        }else if (GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            Log.d(TAG, "isServicesOK: an error occurred but we can fix it");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(getActivity(), available, ERROR_DIALOG_REQUEST);
            dialog.show();
        }else{
            Toast.makeText(getActivity(), "you can't make map requests", Toast.LENGTH_LONG).show();
        }
        return false;
    }

}
