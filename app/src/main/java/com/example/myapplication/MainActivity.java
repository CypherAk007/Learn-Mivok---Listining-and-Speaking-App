package com.example.myapplication;// PACKAGE NAME

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // Find the View that shows the numbers category
//        TextView numbers = (TextView) findViewById(R.id.numbers);
//
//// Set a click listener on that View
//        numbers.setOnClickListener(new View.OnClickListener() {
//            // The code in this method will be executed when the numbers View is clicked on.
//            @Override
//            public void onClick(View view) {
//                Intent numbersIntent = new Intent(MainActivity.this, NumbersActivity.class);
//                startActivity(numbersIntent);
//            }
//        });
//
//        // Find the View that shows the family category
//        TextView family = (TextView) findViewById(R.id.family);
//
//// Set a click listener on that View
//        family.setOnClickListener(new View.OnClickListener() {
//            // The code in this method will be executed when the family View is clicked on.
//            @Override
//            public void onClick(View view) {
//                Intent familyIntent = new Intent(MainActivity.this, FamilyMembersActivity.class);
//                startActivity(familyIntent);
//            }
//        });
//
//        // Find the View that shows the colors category
//        TextView colors = (TextView) findViewById(R.id.colors);
//
//// Set a click listener on that View
//        colors.setOnClickListener(new View.OnClickListener() {
//            // The code in this method will be executed when the colors View is clicked on.
//            @Override
//            public void onClick(View view) {
//                Intent colorsIntent = new Intent(MainActivity.this, ColorActivity.class);
//                startActivity(colorsIntent);
//            }
//        });
//
//        // Find the View that shows the phrases category
//        TextView phrases = (TextView) findViewById(R.id.phrases);
//
//// Set a click listener on that View
//        phrases.setOnClickListener(new View.OnClickListener() {
//            // The code in this method will be executed when the phrases View is clicked on.
//            @Override
//            public void onClick(View view) {
//                Intent phrasesIntent = new Intent(MainActivity.this, PhrasesActivity.class);
//                startActivity(phrasesIntent);
//            }
//        });
//    }
//
////    public void openNumbersList(View view){
////        Intent i = new Intent(this,NumbersActivity.class);
////        startActivity(i);
////
////    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
//        CategoryAdapter adapter = new CategoryAdapter(getSupportFragmentManager());
        CategoryAdapter adapter = new CategoryAdapter(this, getSupportFragmentManager());
        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        // Connect the tab layout with the view pager. This will
        //   1. Update the tab layout when the view pager is swiped
        //   2. Update the view pager when a tab is selected
        //   3. Set the tab layout's tab names with the view pager's adapter's titles
        //      by calling onPageTitle()
        tabLayout.setupWithViewPager(viewPager);
    }
}