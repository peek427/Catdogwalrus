package com.example.zach.catdogwalrus;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;



/**
 *  Created by Zach on 1/27/2015.
 */
public abstract class Minigame extends FragmentActivity {

    protected int Score;

    protected void pushScore() // Pushes high score into the phone's memory.
    {
        SharedPreferences  save = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = save.edit();
        editor.putInt(getString(R.string.high_score), Score);
        editor.commit();
    }


    public void onBackPressed() // do nothing when back is pressed (we implement our own back buttons)
    {

    }
}
