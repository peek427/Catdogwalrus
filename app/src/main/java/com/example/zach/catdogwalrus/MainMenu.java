package com.example.zach.catdogwalrus;

import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;


public class MainMenu extends ActionBarActivity implements OnClickListener{


    private Button chapterselect_button;
    private Button credits_button;
    private Button test_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        // CONNECT BUTTONS TO LAYOUT AND LISTENER
        chapterselect_button = (Button) findViewById(R.id.ChapterSelectButton);
        chapterselect_button.setOnClickListener(this);
        credits_button = (Button) findViewById(R.id.CreditsButton);
        credits_button.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
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
    public void onClick(View v) {
        if (v == credits_button) {
            Intent tocredits = new Intent(v.getContext(), CreditsMenu.class);
            startActivity(tocredits);
        } else if (v == chapterselect_button) {
            Intent tochapterselect = new Intent(v.getContext(), ChapterMenu.class);
            startActivity(tochapterselect);
        }
    }

    }
