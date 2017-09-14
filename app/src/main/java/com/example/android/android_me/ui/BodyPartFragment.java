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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gabriel on 12/09/2017.
 */

public class BodyPartFragment extends Fragment {

    // Final Strings to store state information about the list of images and list index
    public static final String IMAGE_ID_LIST = "image_ids";
    public static final String LIST_INDEX = "list_index";


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

        // Load the saved state (the list of images and list index) if there is one
        if(savedInstanceState != null) {
            mImagesIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex = savedInstanceState.getInt(LIST_INDEX);
        }


        //Inflate the Android-Me fragment layout
        View rootView=inflater.inflate(R.layout.fragment_body_part,container,false);

        //get a reference to the ImageView in the fragment layout
        final ImageView imageView=(ImageView) rootView.findViewById(R.id.body_part_image_view);



        if (mImagesIds!=null){
            //Set the image resource to display
            imageView.setImageResource(mImagesIds.get(mListIndex));

            imageView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    if(mListIndex<mImagesIds.size()-1){
                        mListIndex++;

                    }else{
                        // The end of list has been reached, so return to beginning index
                        mListIndex = 0;

                    }

                    // Set the image resource to the new list item
                    imageView.setImageResource(mImagesIds.get(mListIndex));


                }
            });





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


    /**
     * Save the current state of this fragment
     */
    @Override
    public void onSaveInstanceState(Bundle currentState) {
        currentState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) mImagesIds);
        currentState.putInt(LIST_INDEX, mListIndex);
    }

}
