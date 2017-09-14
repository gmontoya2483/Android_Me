package com.example.android.android_me.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.android.android_me.R;


public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {


    // This activity is responsible for displaying the master list of all images


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    // Define the behavior for onImageSelected
    @Override
    public void onImageSelected(int position) {

        // Create a Toast that displays the position that was clicked
        Toast.makeText(this, "Position clicked = " + position, Toast.LENGTH_SHORT).show();

        // TODO (2) Based on where a user has clicked, store the selected list index for the head, body, and leg BodyPartFragments

        // TODO (3) Put this information in a Bundle and attach it to an Intent that will launch an AndroidMeActivity

        // TODO (4) Get a reference to the "Next" button and launch the intent when this button is clicked



    }



}
