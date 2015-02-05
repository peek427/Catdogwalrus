package com.example.zach.catdogwalrus;

import android.content.ClipData;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.view.View;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.view.View.DragShadowBuilder;
import android.content.Intent;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Zach on 1/27/2015.
 */
public class VariableMinigame extends Minigame {

    private TextView thevariable; // The variable to be dragged into the correct boxes by the user

    private TextView thescore; // Textview for the score
    private TextView thetimer; // Textview for the timer

    private ImageView charbox, intbox, boolbox, stringbox, doublebox; // The imageviews representing the boxes to be dragged onto

    private StringBucket thebucket; // The bucket that holds the strings to be loaded into the draggable variable


    private class StringBucket {
        private Map<Integer, String> stringmap = new HashMap<Integer, String>();
        protected int CurrentString; // holds the key of the current string


        public StringBucket() // Container that holds the strings to be used in variable minigame.
        {


            // 1-10 STRING
            // 11-20 CHAR
            // 21-30 INT
            // 31-40 DOUBLE
            // 41-50 BOOL

            stringmap.put(1, "\"dog\"");
            stringmap.put(2, "\"4334647\"");
            stringmap.put(3, "\"<3walruses\"");
            stringmap.put(4, "\"hello world\"");
            stringmap.put(5, "\"x\"");
            stringmap.put(6, "\"android\"");
            stringmap.put(7, "\"megaman\"");
            stringmap.put(8, "\"zach\"");
            stringmap.put(9, "\"!!!!\"");
            stringmap.put(10, "\"ab c\"");
            stringmap.put(11, "'t'");
            stringmap.put(12, "'@'");
            stringmap.put(13, "'x'");
            stringmap.put(14, "'^'");
            stringmap.put(15, "'\"'");
            stringmap.put(16, "'y'");
            stringmap.put(17, "'k'");
            stringmap.put(18, "'.'");
            stringmap.put(19, "'3'");
            stringmap.put(20, "'0'");
            stringmap.put(21, "2");
            stringmap.put(22, "48");
            stringmap.put(23, "5928630");
            stringmap.put(24, "129");
            stringmap.put(25, "0");
            stringmap.put(26, "33");
            stringmap.put(27, "10");
            stringmap.put(28, "16");
            stringmap.put(29, "999");
            stringmap.put(30, "1");
            stringmap.put(31, "0.4647");
            stringmap.put(32, "252.3");
            stringmap.put(33, "12.00003");
            stringmap.put(34, "0.05");
            stringmap.put(35, "34506.1");
            stringmap.put(36, "86.33333");
            stringmap.put(37, "123.456");
            stringmap.put(38, "100.11");
            stringmap.put(39, "24.56");
            stringmap.put(40, "111.9");
            stringmap.put(41, "true");
            stringmap.put(42, "true");
            stringmap.put(43, "true");
            stringmap.put(44, "true");
            stringmap.put(45, "true");
            stringmap.put(46, "false");
            stringmap.put(47, "false");
            stringmap.put(48, "false");
            stringmap.put(49, "false");
            stringmap.put(50, "false");
            // 5 true and 5 false exist so that when a value between 1-50 is randomly chosen, booleans have the same
            // chance to be selected as any other type.

            generaterandom(); // Set the current string to an intitial value.
        }

        public void generaterandom() // generates a random key used in the stringbucket
        {
            Random myrandom = new Random();
            CurrentString = myrandom.nextInt(50) + 1;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.variable_minigame);


        thevariable = (TextView) findViewById(R.id.VariableGameString); // Connect the "variable" textview to the layout
        thevariable.setOnTouchListener(new VariableListener()); // The listener used to detect touch on the "variable" textview
        thescore = (TextView) findViewById(R.id.Score);

        // Connect the imageviews to the boxes in the layout
        boolbox = (ImageView) findViewById(R.id.Box1);
        stringbox = (ImageView) findViewById(R.id.Box2);
        charbox = (ImageView) findViewById(R.id.Box3);
        intbox = (ImageView) findViewById(R.id.Box4);
        doublebox = (ImageView) findViewById(R.id.Box5);
        // Connect the imageviews to the BoxListener, which detects when the variable is dropped onto them.
        boolbox.setOnDragListener(new BoxListener());
        stringbox.setOnDragListener(new BoxListener());
        charbox.setOnDragListener(new BoxListener());
        intbox.setOnDragListener(new BoxListener());
        doublebox.setOnDragListener(new BoxListener());

        // initialize stringbucket
        thebucket = new StringBucket();

        //initialize score
        Score = 0;
        thescore.setText("0");

        //initialize timer
        thetimer = (TextView) findViewById(R.id.VariableGameTimer);

        new CountDownTimer(30000, 1000) {               // THIS LINE STARTS THE TIMER
            public void onTick(long millisecs) { // CALLED EVERY TICK
                thetimer.setText("" + (millisecs / 1000)); // Output the number of seconds left

            }

            public void onFinish() { // CALLED WHEN THE TIMER IS FINISHED, SO LOCK THE GAME & OUTPUT RESULTS
                thetimer.setText("0");

                // Ideally, a sound will be played, and a window will pop up on top of the variable
                // TextView that shows what score you reached and your old highscore. It can also
                // display whether or not the next lesson has been unlocked already by your score.


            }

        }; // end of timer description
    } // end of onCreate


    private class VariableListener implements OnTouchListener {
        // Listener that handles the variable being touched

        public boolean onTouch(View v, MotionEvent m) {
            if (m.getAction() == MotionEvent.ACTION_DOWN) // "A pressed gesture has started" on the variable
            {
                View.DragShadowBuilder shadow = new View.DragShadowBuilder(v); // Create a dragshadowbuilder for the variable
                ClipData clipped = ClipData.newPlainText(".", "."); // Empty clipdata, may be used later
                v.startDrag(clipped, shadow, v, 0); // This marks the start of a drag
                return true; // return true if the variable was touched
            } else
                return false;

        }

    } // end of touch listener

    private class BoxListener implements OnDragListener {
        //listener that handles things being dragged onto the boxes

        public boolean onDrag(View v, DragEvent d)
        // v is the box being dropped on to
        {
            ImageView box = (ImageView) v;
            TextView var = (TextView) d.getLocalState(); // var holds the actual textview
            if (d.getAction() == DragEvent.ACTION_DROP) // This is the only case we are concerned about
            {
                if (box.getId() == R.id.Box1) // if the box dropped onto is the BOOL box
                {
                    if (thebucket.CurrentString < 51 && thebucket.CurrentString > 40) // if the current variable is within the correct bool key range
                    {
                        Score += 100; // add to score
                        thescore.setText("" + Score); // reset score textview to new score value
                        thebucket.generaterandom(); // make a new variable
                        thevariable.setText(thebucket.stringmap.get(thebucket.CurrentString)); // update the variable in the layout

                        //FUTURE: Make (customized) toasts that pop up with +100 or -50 each time
                    } else // WRONG BUCKET CASE
                    {
                        Score -= 50; // subtract from score
                        if (Score < 0)
                            Score = 0;  //prevents negative scores
                        thescore.setText("" + Score); // reset score textview
                        // let the user try this variable again
                    }
                } else if (box.getId() == R.id.Box2) // STRING BOX
                {
                    if (thebucket.CurrentString < 11 && thebucket.CurrentString > 0) // if the current variable is within the correct bool key range
                    {
                        Score += 100; // add to score
                        thescore.setText("" + Score); // reset score textview to new score value
                        thebucket.generaterandom(); // make a new variable
                        thevariable.setText(thebucket.stringmap.get(thebucket.CurrentString)); // update the variable in the layout
                    } else // WRONG BUCKET CASE
                    {
                        Score -= 50; // subtract from score
                        if (Score < 0)
                            Score = 0;  //prevents negative scores
                        thescore.setText("" + Score); // reset score textview
                        // let the user try this variable again
                    }
                } else if (box.getId() == R.id.Box3) // CHAR BOX
                {
                    if (thebucket.CurrentString < 21 && thebucket.CurrentString > 10) // if the current variable is within the correct bool key range
                    {
                        Score += 100; // add to score
                        thescore.setText("" + Score); // reset score textview to new score value
                        thebucket.generaterandom(); // make a new variable
                        thevariable.setText(thebucket.stringmap.get(thebucket.CurrentString)); // update the variable in the layout
                    } else // WRONG BUCKET CASE
                    {
                        Score -= 50; // subtract from score
                        if (Score < 0)
                            Score = 0;  //prevents negative scores
                        thescore.setText("" + Score); // reset score textview
                        // let the user try this variable again
                    }
                } else if (box.getId() == R.id.Box4) // INT BOX
                {
                    if (thebucket.CurrentString < 31 && thebucket.CurrentString > 20) // if the current variable is within the correct bool key range
                    {
                        Score += 100; // add to score
                        thescore.setText("" + Score); // reset score textview to new score value
                        thebucket.generaterandom(); // make a new variable
                        thevariable.setText(thebucket.stringmap.get(thebucket.CurrentString)); // update the variable in the layout
                    } else // WRONG BUCKET CASE
                    {
                        Score -= 50; // subtract from score
                        if (Score < 0)
                            Score = 0;  //prevents negative scores
                        thescore.setText("" + Score); // reset score textview
                        // let the user try this variable again
                    }
                } else if (box.getId() == R.id.Box5) // DOUBLE BOX
                {
                    if (thebucket.CurrentString < 41 && thebucket.CurrentString > 30) // if the current variable is within the correct bool key range
                    {
                        Score += 100; // add to score
                        thescore.setText("" + Score); // reset score textview to new score value
                        thebucket.generaterandom(); // make a new variable
                        thevariable.setText(thebucket.stringmap.get(thebucket.CurrentString)); // update the variable in the layout
                    } else // WRONG BUCKET CASE
                    {
                        Score -= 50; // subtract from score
                        if (Score < 0)
                            Score = 0;  //prevents negative scores
                        thescore.setText("" + Score); // reset score textview
                        // let the user try this variable again
                    }
                }


            } // end of Action.Event_drop
            return true;
        } // end of onDrag

    } // end of OnDragListener



} // end of entire class

