/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

// This activity will display a custom Android image composed of three body parts: head, body, and legs
public class AndroidMeActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);


        BodyPartFragment headFragment=new BodyPartFragment();

        // TODO (4) Set the list of image id's for the head fragment and set the position to the second image in the list
        headFragment.setImagesIds(AndroidImageAssets.getHeads());
        headFragment.setListIndex(2);

        //Use a FragmentManager and transaction to add the fragment to the screen
        FragmentManager fragmentManager=getSupportFragmentManager();

        //Fragment transaction
        fragmentManager.beginTransaction()
                .add(R.id.head_container,headFragment) //R.id.head_container is the ID of the frame which contains the fragment <FramaLayout.../>
                .commit();

        // TODO (5) Create and display the body and leg BodyPartFragments


        BodyPartFragment bodyFragment=new BodyPartFragment();
        bodyFragment.setImagesIds(AndroidImageAssets.getBodies());
        bodyFragment.setListIndex(1);
        fragmentManager.beginTransaction()
                .add(R.id.body_container,bodyFragment)
                .commit();

        BodyPartFragment legsFragment=new BodyPartFragment();
        legsFragment.setImagesIds(AndroidImageAssets.getLegs());
        fragmentManager.beginTransaction()
                .add(R.id.legs_container,legsFragment)
                .commit();

    }
}
