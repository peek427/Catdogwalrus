package com.example.zach.catdogwalrus;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;


/**
 *  Created by Zach on 1/27/2015.
 */
public abstract class Minigame extends ActionBarActivity{

    protected int Score;

    protected void pushScore() // Pushes high score into the phone's memory.
    {
        System.out.print("okay");
        Context context = this;
        SharedPreferences  save = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = save.edit();
        editor.putInt(getString(R.string.high_score), Score);
        editor.commit();
    }
}
