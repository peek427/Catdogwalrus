package com.example.zach.catdogwalrus;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.ClipData;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.View;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.view.View.DragShadowBuilder;
import android.content.Intent;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import android.os.Handler;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Madeline on 3/23/2015.
 */
public class VariableMinigame2 extends Minigame implements OnClickListener{

    private StringBucket thebucket; // The bucket that holds the strings to be loaded into the draggable variable
    private TextView theQuestion;
    private Button answer1;
    private Button answer2;
    private Button answer3;
    private Button answer4;
    private SharedPreferences save;

    private ImageView star1;
    private ImageView star2;
    private ImageView star3;


    final Context context = this; // Used to refer to context within listeners
    Toast toasty; // TOAST USED FOR SCORING

    int correct = 0; //To check correct number
    private TextView thescore; // Textview for the score

    private Handler myhandler = new Handler(); // Handler for the timer
    private TextView thetimer; // Textview for the timer
    long starttime;

    private class StringBucket {  // Container that holds the strings to be used in variable minigame 2.
        private Map<Integer, String> stringmap = new HashMap<Integer, String>();

        protected int Question; // holds the key of the current quetion
        protected int CorrectAnswer; //Correct answer
        protected int Wrong1; //Wrong answer choice
        protected int Wrong2; //Wrong answer choice
        protected int Wrong3; //Wrong answer choice

        public StringBucket()
        {
            //Questions
            stringmap.put(1, "Which of the following are valid names in c++?");
            stringmap.put(2, "Which of the following are valid names in c++?");
            stringmap.put(3, "Which of the following are valid names in c++?");
            stringmap.put(4, "Which of the following are valid names in c++?");
            stringmap.put(5, "Which of the following are valid names in c++?");
            stringmap.put(6, "Which of these are correct?");
            stringmap.put(7, "Which of these are correct?");
            stringmap.put(8, "Which of these are correct?");
            stringmap.put(9, "Which of these are correct?");
            stringmap.put(10, "Which of these are correct?");
            stringmap.put(11, "int num = 3;\ndouble dec = 2.5\nint sum = num + dec;\nWhat is the value of sum;");
            stringmap.put(12, "int num = 2;\nint num2 = 3\nint sum = num + num2;\nWhat is the value of sum;");
            stringmap.put(13, "int num = 5;\ndouble dec = 2.5\nint diff = num - dec;\nWhat is the value of diff;");
            stringmap.put(14, "int num = 10;\ndouble dec = 3.5\ndouble dif = num - dec;\nWhat is the value of diff;");
            //Answers go here:

            //Correct to 1-5:
            stringmap.put(15, "int NUMBER");//Correct
            stringmap.put(16, "int num_num");//Correct
            stringmap.put(17, "int myNum22");//Correct
            stringmap.put(18, "int n0tY0urNum");//Correct
            stringmap.put(19, "int thirty");//Correct
            stringmap.put(20, "string what");//Correct
            stringmap.put(21, "string p00o00p");//Correct
            stringmap.put(22, "string abcde_lmnop");//Correct
            stringmap.put(23, "string tomato");//Correct
            stringmap.put(24, "string A");//Correct
            stringmap.put(25, "double maybe");//Correct
            stringmap.put(26, "double thisIs_Wrong");//Correct
            stringmap.put(27, "double yourMom");//Correct
            stringmap.put(28, "double poop");//Correct
            stringmap.put(29, "double myDouble");//Correct
            stringmap.put(30, "char q");//Correct
            stringmap.put(31, "char MoM");//Correct
            stringmap.put(32, "char myChar");//Correct
            stringmap.put(33, "char yeesssss");//Correct
            stringmap.put(34, "char no");//Correct

            //Wrong to 1-5:
            stringmap.put(35, "int @2Number!");//Wrong
            stringmap.put(36, "int 90Number");//Wrong
            stringmap.put(37, "int num!!num");//Wrong
            stringmap.put(38, "int 1num");//Wrong
            stringmap.put(39, "int 0o0o0W");//Wrong
            stringmap.put(40, "string wh@t?");//Wrong
            stringmap.put(41, "string yes!");//Wrong
            stringmap.put(42, "string n0?");//Wrong
            stringmap.put(43, "string 1one");//Wrong
            stringmap.put(44, "string 2two");//Wrong
            stringmap.put(45, "double 99.0");//Wrong
            stringmap.put(46, "double ....?");//Wrong
            stringmap.put(47, "double double!");//Wrong
            stringmap.put(48, "double y@s!");//Wrong
            stringmap.put(49, "double M@aybe?");//Wrong
            stringmap.put(50, "char pot@to");//Wrong
            stringmap.put(51, "char Tom@to");//Wrong
            stringmap.put(52, "char youGot!t");//Wrong
            stringmap.put(53, "char 2yumm_y");//Wrong
            stringmap.put(54, "char char");//Wrong

            //Correct to 5-10:
            stringmap.put(55, "double myDouble = 2.0;");//Correct
            stringmap.put(56, "double thisDouble = 1.0;");//Correct
            stringmap.put(57, "double yourDouble = 555.555;");//Correct
            stringmap.put(58, "double his_Double = 222.2;");//Correct
            stringmap.put(59, "double her_Double = 10.10;");//Correct
            stringmap.put(60, "char myChar = 'a';");//Correct
            stringmap.put(61, "char thisChar = '2';");//Correct
            stringmap.put(62, "char yourChar = 'c';");//Correct
            stringmap.put(63, "char his_Char = '@';");//Correct
            stringmap.put(64, "char her_Char = '!';");//Correct
            stringmap.put(65, "int myInt = 1;");//Correct
            stringmap.put(66, "int thisInt = 5000020202;");//Correct
            stringmap.put(67, "int yourInt = 20;");//Correct
            stringmap.put(68, "int his_Int = 202020;");//Correct
            stringmap.put(69, "int her_Int = 1101;");//Correct
            stringmap.put(70, "string myString = \"dog\";");//Correct
            stringmap.put(71, "string thisString =  \"Nooooo!\";");//Correct
            stringmap.put(72, "string yourString =  \"@\";"); //Correct
            stringmap.put(73, "string his_String =  \"A\";");//Correct
            stringmap.put(74, "string her_String = \"poop\";");//Correct

            //Wrong to 5-10:
            stringmap.put(75, "double myDouble = 2;");//Wrong
            stringmap.put(76, "double thisDouble = \"1.0\";");//Wrong
            stringmap.put(77, "double yourDouble = 555;");//Wrong
            stringmap.put(78, "double his_Double = '2';");//Wrong
            stringmap.put(79, "double her_Double = \"yes\";");//Wrong
            stringmap.put(80, "char myChar = 2;");//Wrong
            stringmap.put(81, "char thisChar = 9000;");//Wrong
            stringmap.put(82, "char yourChar = a;");//Wrong
            stringmap.put(83, "char his_Char = \"poop\";");//Wrong
            stringmap.put(84, "char her_Char = 'tomato';");//Wrong
            stringmap.put(85, "int myInt = 11.1;");//Wrong
            stringmap.put(86, "int thisInt = 5000020202.202047;");//Wrong
            stringmap.put(87, "int yourInt = \"  \";");//Wrong
            stringmap.put(88, "int his_Int = '11';");//Wrong
            stringmap.put(89, "int her_Int = \"1101\";");//Wrong
            stringmap.put(90, "string myString = poop;");//Wrong
            stringmap.put(91, "string thisString = 11;");//Wrong
            stringmap.put(92, "string yourString = 'A';"); //Wrong
            stringmap.put(93, "string his_String =  is this is a string?;");//Wrong
            stringmap.put(94, "string her_String =  2.222;");//Wrong

            //Correct to 11 and 12:
            stringmap.put(95, "5");//Answer to 11 and 13.
            //Correct to 13:
            stringmap.put(96, "2");//Answer to 13
            //Correct to 14:
            stringmap.put(97, "6.5");//Answer to 14
            //Wrong to 11-14:
            stringmap.put(98, "5.5");//Wrong
            stringmap.put(99, "6.75");//Wrong
            stringmap.put(100, "6.0");//Wrong
            stringmap.put(101, "5.0");//Wrong
            stringmap.put(102, "5.25");//Wrong
            stringmap.put(103, "3");//Wrong
            stringmap.put(104, "2.05");//Wrong
            stringmap.put(105, "1.5");//
            stringmap.put(106, "3.25");//Wrong
            stringmap.put(107, "4.5");//Wrong
            stringmap.put(108, "7.5");//Wrong
            stringmap.put(109, "7");//Wrong
            stringmap.put(110, "10");//Wrong



        }

        public void generaterandom() // generates random keys used in the stringbucket
        {

            answer1.setBackgroundColor(Color.YELLOW);
            answer2.setBackgroundColor(Color.YELLOW);
            answer3.setBackgroundColor(Color.YELLOW);
            answer4.setBackgroundColor(Color.YELLOW);

            Random myrandom = new Random();
            Question = myrandom.nextInt(14) + 1;
            theQuestion.setText(thebucket.stringmap.get(thebucket.Question));

            if(Question <= 5)
            {
                myrandom = new Random();
                CorrectAnswer = myrandom.nextInt((34 - 15) + 1) + 15; //Random correct answer
                myrandom = new Random();
                Wrong1 = myrandom.nextInt((54 - 35) + 1) + 35; //Random wrong answer
                myrandom = new Random();
                Wrong2 = myrandom.nextInt((54 - 35) + 1) + 35; //Random wrong answer
                myrandom = new Random();
                Wrong3 = myrandom.nextInt((54 - 35) + 1) + 35; //Random wrong answer
            }
            else if(Question <= 10)
            {
                myrandom = new Random();
                CorrectAnswer = myrandom.nextInt((74 - 55) + 1) + 55; //Random correct answer
                myrandom = new Random();
                Wrong1 = myrandom.nextInt((94 - 75) + 1) + 75; //Random wrong answer
                myrandom = new Random();
                Wrong2 = myrandom.nextInt((94 - 75) + 1) + 75; //Random wrong answer
                myrandom = new Random();
                Wrong3 = myrandom.nextInt((94 - 75) + 1) + 75; //Random wrong answer
            }
            else if(Question == 11 || Question == 12)
            {
                CorrectAnswer = 95;
                myrandom = new Random();
                Wrong1 = myrandom.nextInt((110 - 98) + 1) + 98; //Random wrong answer
                myrandom = new Random();
                Wrong2 = myrandom.nextInt((110 - 98) + 1) + 98; //Random wrong answer
                myrandom = new Random();
                Wrong3 = myrandom.nextInt((110 - 98) + 1) + 98; //Random wrong answer
            }
            else if(Question == 13)
            {
                CorrectAnswer = 96;
                Wrong1 = myrandom.nextInt((110 - 98) + 1) + 98; //Random wrong answer
                myrandom = new Random();
                Wrong2 = myrandom.nextInt((110 - 98) + 1) + 98; //Random wrong answer
                myrandom = new Random();
                Wrong3 = myrandom.nextInt((110 - 98) + 1) + 98; //Random wrong answer
            }
            else if(Question == 14)
            {
                CorrectAnswer = 97;
                Wrong1 = myrandom.nextInt((110 - 98) + 1) + 98; //Random wrong answer
                myrandom = new Random();
                Wrong2 = myrandom.nextInt((110 - 98) + 1) + 98; //Random wrong answer
                myrandom = new Random();
                Wrong3 = myrandom.nextInt((110 - 98) + 1) + 98; //Random wrong answer
            }

            myrandom = new Random();
            if((myrandom.nextInt((4 - 1) + 1) + 1)== 1)
            {
                correct = 1;
                answer1.setText(thebucket.stringmap.get(thebucket.CorrectAnswer));
                answer2.setText(thebucket.stringmap.get(thebucket.Wrong1));
                answer3.setText(thebucket.stringmap.get(thebucket.Wrong2));
                answer4.setText(thebucket.stringmap.get(thebucket.Wrong3));
            }
            else if((myrandom.nextInt((4 - 1) + 1) + 1)== 2)
            {
                correct = 2;
                answer1.setText(thebucket.stringmap.get(thebucket.Wrong1));
                answer2.setText(thebucket.stringmap.get(thebucket.CorrectAnswer));
                answer3.setText(thebucket.stringmap.get(thebucket.Wrong2));
                answer4.setText(thebucket.stringmap.get(thebucket.Wrong3));
            }
            else if((myrandom.nextInt((4 - 1) + 1) + 1)== 3)
            {
                correct = 3;
                answer1.setText(thebucket.stringmap.get(thebucket.Wrong1));
                answer2.setText(thebucket.stringmap.get(thebucket.Wrong2));
                answer3.setText(thebucket.stringmap.get(thebucket.CorrectAnswer));
                answer4.setText(thebucket.stringmap.get(thebucket.Wrong3));
            }
            else
            {
                correct = 4;
                answer1.setText(thebucket.stringmap.get(thebucket.Wrong1));
                answer2.setText(thebucket.stringmap.get(thebucket.Wrong2));
                answer3.setText(thebucket.stringmap.get(thebucket.Wrong3));
                answer4.setText(thebucket.stringmap.get(thebucket.CorrectAnswer));
            }

        }//End of GenerateRandom
    }//End of stringBucket

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.variable_minigame2);
        theQuestion= (TextView) findViewById((R.id.theQuestion));
        answer1 = (Button) findViewById(R.id.answer1);
        answer1.setOnClickListener(this);
        answer2 = (Button) findViewById(R.id.answer2);
        answer2.setOnClickListener(this);
        answer3 = (Button) findViewById(R.id.answer3);
        answer3.setOnClickListener(this);
        answer4 = (Button) findViewById(R.id.answer4);
        answer4.setOnClickListener(this);

        answer1.setBackgroundColor(Color.YELLOW);
        answer2.setBackgroundColor(Color.YELLOW);
        answer3.setBackgroundColor(Color.YELLOW);
        answer4.setBackgroundColor(Color.YELLOW);

        save = this.getPreferences(Context.MODE_PRIVATE); // Connects the save to the save variable
        thescore = (TextView) findViewById(R.id.Score);

        // initialize stringbucket
        thebucket = new StringBucket();
        thebucket.generaterandom();

        //initialize score
        Score = 0;
        thescore.setText("0");


        //initialize timer
        thetimer = (TextView) findViewById(R.id.Timer);



        // THIS IS WHERE THE TIMER STARTS
        starttime = SystemClock.uptimeMillis();
        myhandler.postDelayed(TimerThread, 0);

        //Stars
        star1 = (ImageView) findViewById(R.id.starSet1_2_1);
        star2 = (ImageView) findViewById(R.id.starSet1_2_2);
        star3 = (ImageView) findViewById(R.id.starSet1_2_3);

    }//End onCreate

    @Override
    public void onClick(View v)
    {
        if (v == answer1)
        {

            if(correct == 1)
            {
                Score += 100; // add to score
                thescore.setText("" + Score); // reset score textview to new score value
                thebucket.generaterandom();

            }
            else
            {
                Score -= 50; // subtract from score
                if (Score < 0)
                    Score = 0;  //prevents negative scores
                thescore.setText("" + Score); // reset score textview
                answer1.setBackgroundColor(Color.RED);

            }
        }
        if (v == answer2)
        {
            if(correct == 2)
            {
                Score += 100; // add to score
                thescore.setText("" + Score); // reset score textview to new score value
                thebucket.generaterandom();


            }
            else
            {
                Score -= 50; // subtract from score
                if (Score < 0)
                    Score = 0;  //prevents negative scores
                thescore.setText("" + Score); // reset score textview
                answer2.setBackgroundColor(Color.RED);
            }
        }
        if (v == answer3)
        {
            if(correct == 3)
            {
                Score += 100; // add to score
                thescore.setText("" + Score); // reset score textview to new score value
                thebucket.generaterandom();


            }
            else
            {
                Score -= 50; // subtract from score
                if (Score < 0)
                    Score = 0;  //prevents negative scores
                thescore.setText("" + Score); // reset score textview
                answer3.setBackgroundColor(Color.RED);

            }
        }
        if (v == answer4)
        {
            if(correct ==4)
            {
                Score += 100; // add to score
                thescore.setText("" + Score); // reset score textview to new score value
                thebucket.generaterandom();
      

            }
            else
            {
                Score -= 50; // subtract from score
                if (Score < 0)
                    Score = 0;  //prevents negative scores
                thescore.setText("" + Score); // reset score textview
                answer4.setBackgroundColor(Color.RED);
            }
        }

    }//End of onClick

    private Runnable TimerThread = new Runnable()
    {
        long ms = 0L;
        long buffer = 0L;
        long updated = 0L;
        public void run() {

            ms = SystemClock.uptimeMillis() - starttime;
            updated = buffer + ms;

            int sec = (int) (updated / 1000);
            thetimer.setText("" + (30 - sec));
            if (sec < 30)
                myhandler.postDelayed(this, 0);
            else {


                //IMPORTANT ********************************************************************************
                // THIS CODE SEGMENT IS HOW YOU MAKE THE END-OF-GAME SCORE DIALOG BOX APPEAR
                FragmentManager fm = getSupportFragmentManager();
                Score_alert_fragment_variableMinigame2 alertfragment = new Score_alert_fragment_variableMinigame2();

                //Retrieve high score from preferences
                if (save.getInt(getString(R.string.high_score), 0) < Score) // If the high score is less than the score
                {
                    pushScore();
                    if(save.getInt(getString(R.string.high_score), 0) < 100)
                    {
                        //set the stars here.
                        star1.setBackgroundResource(R.drawable.full_yello);
                    }
                    else if(save.getInt(getString(R.string.high_score), 0) < 200)
                    {
                        //set the stars here.
                        star1.setBackgroundResource(R.drawable.full_yello);
                        star2.setBackgroundResource(R.drawable.full_yello);
                    }
                    else
                    {
                        //set the stars here.
                        star1.setBackgroundResource(R.drawable.full_yello);
                        star2.setBackgroundResource(R.drawable.full_yello);
                        star3.setBackgroundResource(R.drawable.full_yello);
                    }
                }

                alertfragment.y=Score; // value of score
                alertfragment.h=save.getInt(getString(R.string.high_score), 0); // value of high score taken from save
                alertfragment.show(fm, "scorefrag");
                // END OF CODE SEGMENT ******************************************************************


                // Ideally, a sound will be played, and a window will pop up on top of the variable
                // TextView that shows what score you reached and your old highscore. It can also
                // display whether or not the next lesson has been unlocked already by your score.

            }
        }
    };

}//end of class
