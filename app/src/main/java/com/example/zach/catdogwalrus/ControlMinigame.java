package com.example.zach.catdogwalrus;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class ControlMinigame extends Minigame implements OnClickListener {


    private ImageView mainred;
    private TextView mainredtext;

    private ImageView maingreen;
    private TextView maingreentext;

    private ImageView mainblue;
    private TextView mainbluetext;

    private ImageView choiceblue1;
    private ImageView choiceblue2;
    private ImageView choiceblue3;
    private TextView choiceblue1text;
    private TextView choiceblue2text;
    private TextView choiceblue3text;


    private ImageView choicegreen1;
    private ImageView choicegreen2;
    private ImageView choicegreen3;
    private TextView choicegreen1text;
    private TextView choicegreen2text;
    private TextView choicegreen3text;

    private ImageView choicered1;
    private ImageView choicered2;
    private ImageView choicered3;
    private ImageView choicered4;
    private TextView choicered1text;
    private TextView choicered2text;
    private TextView choicered3text;
    private TextView choicered4text;

    private ImageView lastchoicered;
    private ImageView lastchoiceblue;
    private ImageView lastchoicegreen;
    private TextView lastchoiceredtext;
    private TextView lastchoicebluetext;
    private TextView lastchoicegreentext;

    private boolean greenchosen;
    private boolean bluechosen;
    private boolean redchosen;

    private TextView prompt;
    private TextView thescore;
    private Button confirmbutton;

    private SharedPreferences save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_minigame);

        thescore = (TextView) findViewById(R.id.Score);
        Score=0;

        mainred = (ImageView) findViewById(R.id.c2image);
        mainredtext = (TextView) findViewById(R.id.c2text);

        maingreen = (ImageView) findViewById(R.id.c3image);
        maingreentext = (TextView) findViewById(R.id.c3text);

        mainblue = (ImageView) findViewById(R.id.c1image);
        mainbluetext = (TextView) findViewById(R.id.c1text);

        choiceblue1 = (ImageView) findViewById(R.id.onechoice_1image);
        choiceblue1.setOnClickListener(this);
        choiceblue1text = (TextView) findViewById(R.id.onechoice_1text);
        choiceblue2 = (ImageView) findViewById(R.id.onechoice_2image);
        choiceblue2.setOnClickListener(this);
        choiceblue2text = (TextView) findViewById(R.id.onechoice_2text);
        choiceblue3 = (ImageView) findViewById(R.id.onechoice_3image);
        choiceblue3.setOnClickListener(this);
        choiceblue3text = (TextView) findViewById(R.id.onechoice_3text);

        choicegreen1 = (ImageView) findViewById(R.id.threechoice_1image);
        choicegreen1.setOnClickListener(this);
        choicegreen1text = (TextView) findViewById(R.id.threechoice_1text);
        choicegreen2 = (ImageView) findViewById(R.id.threechoice_2image);
        choicegreen2.setOnClickListener(this);
        choicegreen2text = (TextView) findViewById(R.id.threechoice_2text);
        choicegreen3 = (ImageView) findViewById(R.id.threechoice_3image);
        choicegreen3.setOnClickListener(this);
        choicegreen3text = (TextView) findViewById(R.id.threechoice_3text);

        choicered1 = (ImageView) findViewById(R.id.twochoice_1image);
        choicered1.setOnClickListener(this);
        choicered1text = (TextView) findViewById(R.id.twochoice_1text);
        choicered2 = (ImageView) findViewById(R.id.twochoice_2image);
        choicered2.setOnClickListener(this);
        choicered2text = (TextView) findViewById(R.id.twochoice_2text);
        choicered3 = (ImageView) findViewById(R.id.twochoice_3image);
        choicered3.setOnClickListener(this);
        choicered3text = (TextView) findViewById(R.id.twochoice_3text);
        choicered4 = (ImageView) findViewById(R.id.twochoice_4image);
        choicered4.setOnClickListener(this);
        choicered4text = (TextView) findViewById(R.id.twochoice_4text);

        prompt = (TextView) findViewById(R.id.controlprompt);
        confirmbutton = (Button) findViewById(R.id.confirmbutton);
        confirmbutton.setOnClickListener(this);



        // INITIALIZE PROMPT 1

        thescore.setText("0");
        prompt.setText("Counts to 5");
        choicegreen1text.setText(this.getString(R.string.wg1));
        choicegreen2text.setText(this.getString(R.string.lg1_1));
        choicegreen3text.setText(this.getString(R.string.lg1_2));

        choicered1text.setText(this.getString(R.string.lr1_1));
        choicered2text.setText(this.getString(R.string.lr1_2));
        choicered3text.setText(this.getString(R.string.lr1_3));
        choicered4text.setText(this.getString(R.string.wr1));

        lastchoicered = choicered1;
        lastchoiceredtext = choicered1text;

        lastchoicegreen = choicegreen1;
        lastchoicegreentext = choicegreen1text;

        lastchoiceblue = choiceblue1;
        lastchoicebluetext = choiceblue1text;

        redchosen=false;
        bluechosen=false;
        greenchosen=false;
        save = this.getPreferences(Context.MODE_PRIVATE); // Connects the save to the save variable


    }

    public void onClick(View v) {

        if (v == choicegreen1)
        {
            greenchosen=true;
            lastchoicegreen.setVisibility(View.VISIBLE);
            lastchoicegreentext.setVisibility(View.VISIBLE);
            lastchoicegreen = choicegreen1;
            lastchoicegreentext = choicegreen1text;
            maingreen.setImageResource(R.drawable.redfull);
            maingreentext.setText(choicegreen1text.getText());
            choicegreen1.setVisibility(View.GONE);
            choicegreen1text.setVisibility(View.GONE);
        }
        else if (v == choicegreen2)
        {
            greenchosen=true;
            lastchoicegreen.setVisibility(View.VISIBLE);
            lastchoicegreentext.setVisibility(View.VISIBLE);
            lastchoicegreen = choicegreen2;
            lastchoicegreentext = choicegreen2text;
            maingreen.setImageResource(R.drawable.redfull);
            maingreentext.setText(choicegreen2text.getText());
            choicegreen2.setVisibility(View.GONE);
            choicegreen2text.setVisibility(View.GONE);
        }
       else if (v == choicegreen3)
        {
            greenchosen=true;
            lastchoicegreen.setVisibility(View.VISIBLE);
            lastchoicegreentext.setVisibility(View.VISIBLE);
            lastchoicegreen = choicegreen3;
            lastchoicegreentext = choicegreen3text;
            maingreen.setImageResource(R.drawable.redfull);
            maingreentext.setText(choicegreen3text.getText());
            choicegreen3.setVisibility(View.GONE);
            choicegreen3text.setVisibility(View.GONE);
        }

        else if (v == choiceblue1)
        {
            bluechosen=true;
            lastchoiceblue.setVisibility(View.VISIBLE);
            lastchoicebluetext.setVisibility(View.VISIBLE);
            lastchoiceblue = choiceblue1;
            lastchoicebluetext = choiceblue1text;
            mainblue.setImageResource(R.drawable.bluefull);
            mainbluetext.setText(choiceblue1text.getText());
            choiceblue1.setVisibility(View.GONE);
            choiceblue1text.setVisibility(View.GONE);
        }
        else if (v ==choiceblue2)
        {
            bluechosen=true;
            lastchoiceblue.setVisibility(View.VISIBLE);
            lastchoicebluetext.setVisibility(View.VISIBLE);
            lastchoiceblue = choiceblue2;
            lastchoicebluetext = choiceblue2text;
            mainblue.setImageResource(R.drawable.bluefull);
            mainbluetext.setText(choiceblue2text.getText());
            choiceblue2.setVisibility(View.GONE);
            choiceblue2text.setVisibility(View.GONE);
        }
        else if (v == choiceblue3)
        {
            bluechosen=true;
            lastchoiceblue.setVisibility(View.VISIBLE);
            lastchoicebluetext.setVisibility(View.VISIBLE);
            lastchoiceblue = choiceblue3;
            lastchoicebluetext = choiceblue3text;
            mainblue.setImageResource(R.drawable.bluefull);
            mainbluetext.setText(choiceblue3text.getText());
            choiceblue3.setVisibility(View.GONE);
            choiceblue3text.setVisibility(View.GONE);
        }
        else if (v == choicered1)
        {
            redchosen=true;
            lastchoicered.setVisibility(View.VISIBLE);
            lastchoiceredtext.setVisibility(View.VISIBLE);
            lastchoicered = choicered1;
            lastchoiceredtext = choicered1text;
            mainred.setImageResource(R.drawable.greenfull);
            mainredtext.setText(choicered1text.getText());
            choicered1.setVisibility(View.GONE);
            choicered1text.setVisibility(View.GONE);
        }
        else if (v == choicered2)
        {
            redchosen=true;
            lastchoicered.setVisibility(View.VISIBLE);
            lastchoiceredtext.setVisibility(View.VISIBLE);
            lastchoicered = choicered2;
            lastchoiceredtext = choicered2text;
            mainred.setImageResource(R.drawable.greenfull);
            mainredtext.setText(choicered2text.getText());
            choicered2.setVisibility(View.GONE);
            choicered2text.setVisibility(View.GONE);
        }
        else if (v == choicered3)
        {
            redchosen=true;
            lastchoicered.setVisibility(View.VISIBLE);
            lastchoiceredtext.setVisibility(View.VISIBLE);
            lastchoicered = choicered3;
            lastchoiceredtext = choicered3text;
            mainred.setImageResource(R.drawable.greenfull);
            mainredtext.setText(choicered3text.getText());
            choicered3.setVisibility(View.GONE);
            choicered3text.setVisibility(View.GONE);
        }
        else if (v == choicered4)
        {
            redchosen=true;
            lastchoicered.setVisibility(View.VISIBLE);
            lastchoiceredtext.setVisibility(View.VISIBLE);
            lastchoicered = choicered4;
            lastchoiceredtext = choicered4text;
            mainred.setImageResource(R.drawable.greenfull);
            mainredtext.setText(choicered4text.getText());
            choicered4.setVisibility(View.GONE);
            choicered4text.setVisibility(View.GONE);
        }

        else if (v == confirmbutton)
        {

            if (prompt.getText().equals("Counts to 5"))
            {


                // Win condition for this prompt. If the player meets the win condition, somehow indicate they got it correct
                if (mainbluetext.getText().equals("for") && mainredtext.getText().equals(getString(R.string.wr1)) && maingreentext.getText().equals(getString(R.string.wg1)))
                {
                    //update score
                    Score+=100;
                    thescore.setText("" + Score);
                }
                else // if they didn't get it correct, indicate they got it wrong
                {

                }

                //either way, reset the prompt

                choicegreen1text.setText(getString(R.string.lg2_1));
                choicegreen2text.setText(getString(R.string.lg2_2));
                choicegreen3text.setText(getString(R.string.wg2));
                choicered1text.setText(getString(R.string.lr2_1));
                choicered2text.setText(getString(R.string.wr2));
                choicered3text.setText(getString(R.string.lr2_2));
                choicered4text.setText(getString(R.string.lr2_3));

                lastchoicegreentext=choicegreen1text;
                lastchoicebluetext=choiceblue1text;
                lastchoiceredtext=choicered1text;
                prompt.setText("Makes Walrus false if Number isn't 3");



            }
            else if (prompt.getText() == "Makes Walrus false if Number isn't 3")
            {
                if (mainbluetext.getText().equals("if") && mainredtext.getText().equals(getString(R.string.wr2)) && maingreentext.getText().equals(getString(R.string.wg2)))
                {

                    //update score
                    Score+=100;
                    thescore.setText("" + Score);
                }
                else // if they didn't get it correct, indicate they got it wrong
                {

                }
                choicegreen1text.setText(getString(R.string.lg3_1));
                choicegreen2text.setText(getString(R.string.wg3));
                choicegreen3text.setText(getString(R.string.lg3_2));
                choicered1text.setText(getString(R.string.lr3_1));
                choicered2text.setText(getString(R.string.lr3_2));
                choicered3text.setText(getString(R.string.wr3));
                choicered4text.setText(getString(R.string.lr3_3));
                prompt.setText("Increases Number by 1 until it is positive");
            }
            else if (prompt.getText() == "Increases Number by 1 until it is positive")
            {
                if (mainbluetext.getText().equals("while") && mainredtext.getText().equals(getString(R.string.wr3)) && maingreentext.getText().equals(getString(R.string.wg3)))
                {

                    //update score
                    Score+=100;
                    thescore.setText("" + Score);
                }
                else // if they didn't get it correct, indicate they got it wrong
                {

                }
                choicegreen1text.setText(getString(R.string.wg4));
                choicegreen2text.setText(getString(R.string.lg4_2));
                choicegreen3text.setText(getString(R.string.lg4_1));
                choicered1text.setText(getString(R.string.lr4_1));
                choicered2text.setText(getString(R.string.wr4));
                choicered3text.setText(getString(R.string.lr4_2));
                choicered4text.setText(getString(R.string.lr4_3));
                prompt.setText("Sets Number to 0 if it is negative, and 1 if it is positive");
            }
            else if (prompt.getText() == "Sets Number to 0 if it is negative, and 1 if it is positive")
            {
                if (mainbluetext.getText().equals("if") && mainredtext.getText().equals(getString(R.string.wr4)) && maingreentext.getText().equals(getString(R.string.wg4)))
                {

                    //update score
                    Score+=100;
                    thescore.setText("" + Score);
                }
                else // if they didn't get it correct, indicate they got it wrong
                {

                }
                choicegreen1text.setText(getString(R.string.lg5_1));
                choicegreen2text.setText(getString(R.string.lg5_2));
                choicegreen3text.setText(getString(R.string.wg5));
                choicered1text.setText(getString(R.string.lr5_1));
                choicered2text.setText(getString(R.string.lr5_3));
                choicered3text.setText(getString(R.string.lr5_2));
                choicered4text.setText(getString(R.string.wr5));
                prompt.setText("Increases Number by 2 ten times");
            }
            else if (prompt.getText() == "Increases Number by 2 ten times")
            {
                if (mainbluetext.getText().equals("for") && mainredtext.getText().equals(getString(R.string.wr5)) && maingreentext.getText().equals(getString(R.string.wg5)))
                {

                    //update score
                    Score+=100;
                    thescore.setText("" + Score);
                }
                else // if they didn't get it correct, indicate they got it wrong
                {

                }

                // last prompt, so end the game here
                FragmentManager fm = getSupportFragmentManager();
                Score_alert_fragment_controlminigame alertfragment = new Score_alert_fragment_controlminigame();

                //Retrieve high score from preferences
                if (save.getInt(getString(R.string.high_score), 0) < Score) // If the high score is less than the score
                {
                    pushScore();
                }

                alertfragment.y=Score; // value of score
                alertfragment.h=save.getInt(getString(R.string.high_score), 0); // value of high score taken from save
                alertfragment.show(fm, "scorefrag");
            }

            redchosen=false;
            greenchosen=false;
            bluechosen=false;

            maingreen.setImageResource(R.drawable.redempty);
            mainred.setImageResource(R.drawable.greenempty);
            mainblue.setImageResource(R.drawable.blueempty);
            maingreentext.setText("");
            mainbluetext.setText("");
            mainredtext.setText("");
            choiceblue1.setVisibility(View.VISIBLE);
            choiceblue2.setVisibility(View.VISIBLE);
            choiceblue3.setVisibility(View.VISIBLE);
            choicegreen1.setVisibility(View.VISIBLE);
            choicegreen2.setVisibility(View.VISIBLE);
            choicegreen3.setVisibility(View.VISIBLE);
            choicered1.setVisibility(View.VISIBLE);
            choicered2.setVisibility(View.VISIBLE);
            choicered3.setVisibility(View.VISIBLE);
            choicered4.setVisibility(View.VISIBLE);
            choicered1text.setVisibility(View.VISIBLE);
            choicered2text.setVisibility(View.VISIBLE);
            choicered3text.setVisibility(View.VISIBLE);
            choicered4text.setVisibility(View.VISIBLE);
            choiceblue1text.setVisibility(View.VISIBLE);
            choiceblue2text.setVisibility(View.VISIBLE);
            choiceblue3text.setVisibility(View.VISIBLE);
            choicegreen1text.setVisibility(View.VISIBLE);
            choicegreen2text.setVisibility(View.VISIBLE);
            choicegreen3text.setVisibility(View.VISIBLE);
            choicered1text.setVisibility(View.VISIBLE);
            choicered2text.setVisibility(View.VISIBLE);
            choicered3text.setVisibility(View.VISIBLE);
            choicered4text.setVisibility(View.VISIBLE);

            lastchoiceredtext=choicered1text;
            lastchoicebluetext=choiceblue1text;
            lastchoicegreentext=choicegreen1text;
            confirmbutton.setVisibility(View.GONE);

        }

        if (redchosen == true && bluechosen == true && greenchosen == true)
        {
            confirmbutton.setVisibility(View.VISIBLE);
        }

    }

}
