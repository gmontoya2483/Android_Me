package com.example.android.android_me.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.android_me.R;

public class MainActivity extends AppCompatActivity {


    // This activity is responsible for displaying the master list of all images
// TODO (4) Implement the MasterListFragment callback, OnImageClickListener

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // TODO (5) Define the behavior for onImageSelected; create a Toast that displays the position clicked

}
