package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.List;

/**
 * Created by Gabriel on 12/09/2017.
 */

public class BodyPartFragment extends Fragment {

    // TODO (3) Create final Strings to store state information about the list of images and list index

    //Tag for logging
    private static final String TAG = "BodyPartFragment";


    // Variables to store a list of image resources and the index of the image that this fragment displays
    private List<Integer> mImagesIds;
    private int mListIndex;


    //Mandatory constructor for instantiating the fragment
    public BodyPartFragment() {

    }

    /**
     * Inflates the fragment layout and sets any image resources
     */
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //Inflate the Android-Me fragment layout
        View rootView=inflater.inflate(R.layout.fragment_body_part,container,false);

        //get a reference to the ImageView in the fragment layout
        ImageView imageView=(ImageView) rootView.findViewById(R.id.body_part_image_view);



        if (mImagesIds!=null){
            //Set the image resource to display
            imageView.setImageResource(mImagesIds.get(mListIndex));

            // TODO (1) Set a click listener on the image view and on a click increment the list index and set the image resource
            // TODO (2) If you reach the end of a list of images, set the list index back to 0 (the first item in the list)



        }else{
            Log.e(TAG, getString(R.string.log_empty_list));

        }


        // Return the root view
        return rootView;
    }


    // Setter methods for keeping track of the list images this fragment can display and which image
    // in the list is currently being displayed

    public void setImagesIds(List<Integer> mImagesIds) {
        this.mImagesIds = mImagesIds;
    }

    public void setListIndex(int mListIndex) {
        this.mListIndex = mListIndex;
    }

    // TODO (4) Override onSaveInstanceState and save the current state of this fragment

}
