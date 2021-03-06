package com.example.zach.catdogwalrus;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.view.View;
import android.content.Intent;


public class Chapter1 extends ActionBarActivity implements OnClickListener{

    private Button Ch1Les1;
    private Button Ch1Les2;
    private Button Ch1Les3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter_1);

        // CONNECT BUTTONS TO LAYOUT AND LISTENERS
        Ch1Les1 = (Button) findViewById(R.id.Ch1Les1);
        Ch1Les1.setOnClickListener(this);
        Ch1Les2 = (Button) findViewById(R.id.Ch1Les2);
        Ch1Les2.setOnClickListener(this);
        Ch1Les3 = (Button) findViewById(R.id.Ch1Les3);
        Ch1Les3.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chapter_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v)
    {
        if (v == Ch1Les1)
        {
            // go to lesson 1
            Intent to_lesson_1= new Intent(v.getContext(), Lesson1_1.class);
            startActivity(to_lesson_1);
        }
        if (v == Ch1Les2)
        {
            // go to lesson 2
            Intent to_lesson_2= new Intent(v.getContext(), Lesson1_2.class);
            startActivity(to_lesson_2);
        }
        if (v == Ch1Les3)
        {
            // go to lesson 2
            Intent to_lesson_3 = new Intent(v.getContext(), Lesson1_3.class);
            startActivity(to_lesson_3);
        }

    }
}