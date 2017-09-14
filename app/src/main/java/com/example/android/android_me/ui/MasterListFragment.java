package com.example.android.android_me.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

/**
 * Created by Gabriel on 14/09/2017.
 */

public class MasterListFragment extends Fragment {


    // TODO (1) Define a new interface OnImageClickListener that triggers a callback in the host activity
    // The callback is a method named onImageSelected(int position) that contains information about
    // which position on the grid of images a user has clicked

    //Define a new interface InImageClickListener that triggers a callback in the host activity
    OnImageClickListener mCallback;


    // On ImageClickListener interface, calls a method in the host activity named onImageSelected
    public interface OnImageClickListener {
        void onImageSelected (int position);
    }





    // TODO (2) Override onAttach to make sure that the container activity has implemented the callback

    //onAttach is where a fragment attaches itself
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //This makes sure that the host activity has implemented the callback interface
        // if not, it throws an exception
        try{
            mCallback=(OnImageClickListener) context;

        }catch (ClassCastException e){
            throw new ClassCastException(context.toString()
                    + " must implement OnImageClickListener");
        }
    }

    //Mandatory empty constructor
    public MasterListFragment() {

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView=inflater.inflate(R.layout.fragment_master_list, container, false);

        // Get a reference to the GridView in the fragment_master_list xml layout file
        GridView gridView = (GridView) rootView.findViewById(R.id.images_grid_view);

        // Create the adapter
        // This adapter takes in the context and an ArrayList of ALL the image resources to display
        MasterListAdapter mAdapter = new MasterListAdapter(getContext(), AndroidImageAssets.getAll());


        // Set the adapter on the GridView
        gridView.setAdapter(mAdapter);


        // TODO (3) Set a click listener on the gridView and trigger the callback onImageSelected when an item is clicked
        // Set a click listener on the gridView and trigger the callback onImageselected when an item is clicked
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Trigger the callback method and pass in the position that was clicked
                mCallback.onImageSelected(position);

            }
        });


        // Return the root view
        return rootView;
    }
}
