package com.example.zach.catdogwalrus;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.ClipData;
import android.content.Context;
import android.content.SharedPreferences;
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
public class VariableMinigame2 {

    private class StringBucket {  // Container that holds the strings to be used in variable minigame.
        private Map<Integer, String> stringmap = new HashMap<Integer, String>();
        protected int CurrentString; // holds the key of the current string


        public StringBucket()
        {
            //Questions
            stringmap.put(1, "Which of the following are valid names in c++?");
            stringmap.put(2, "Which of these are correct?");

      /*      stringmap.put(3, "int num = 3;\ndouble dec = 2.5\nint sum = num + dec;\nWhat is the value of sum;");
            stringmap.put(4, "int num = 3;\ndouble dec = 2.5\nint sum = num + dec;\nWhat is the value of sum;");
            stringmap.put(5, "int num = 3;\ndouble dec = 2.5\nint sum = num + dec;\nWhat is the value of sum;");
            //Answers go here:
            //Correct to 3:
            stringmap.put(4, "5");//Answer to 3.
            //Wrong to 3:
            stringmap.put(5, "5.5");//Wrong
            stringmap.put(5, "6.5");//Wrong
            stringmap.put(5, "6.0");//Wrong
            stringmap.put(5, "5.0");//Wrong
            stringmap.put(5, "5.25");//Wrong
            stringmap.put(5, "3");//Wrong
            stringmap.put(5, "2.5");//Wrong
            stringmap.put(5, "1.5");//Wrong
            stringmap.put(5, "55");//Wrong
       */
            //Correct to 1:
            stringmap.put(5, "int NUMBER");//Correct
            stringmap.put(5, "int num_num");//Correct
            stringmap.put(5, "int myNum22");//Correct
            stringmap.put(5, "int n0tY0urNum");//Correct
            stringmap.put(5, "int thirty");//Correct
            stringmap.put(5, "string what");//Correct
            stringmap.put(5, "string p00o00p");//Correct
            stringmap.put(5, "string abcde_lmnop");//Correct
            stringmap.put(5, "string tomato");//Correct
            stringmap.put(5, "string A");//Correct
            stringmap.put(5, "double maybe");//Correct
            stringmap.put(5, "double thisIs_Wrong");//Correct
            stringmap.put(5, "double yourMom");//Correct
            stringmap.put(5, "double poop");//Correct
            stringmap.put(5, "double myDouble");//Correct
            stringmap.put(5, "char q");//Correct
            stringmap.put(5, "char MoM");//Correct
            stringmap.put(5, "char myChar");//Correct
            stringmap.put(5, "char yeesssss");//Correct
            stringmap.put(5, "char no");//Correct

            //Wrong to 1:
            stringmap.put(5, "int @2Number!");//Wrong
            stringmap.put(5, "int 90Number");//Wrong
            stringmap.put(5, "int num!!num");//Wrong
            stringmap.put(5, "int 1num");//Wrong
            stringmap.put(5, "int 0o0o0W");//Wrong
            stringmap.put(5, "string wh@t?");//Wrong
            stringmap.put(5, "string yes!");//Wrong
            stringmap.put(5, "string n0?");//Wrong
            stringmap.put(5, "string 1one");//Wrong
            stringmap.put(5, "string 2two");//Wrong
            stringmap.put(5, "double 99.0");//Wrong
            stringmap.put(5, "double ....?");//Wrong
            stringmap.put(5, "double double!");//Wrong
            stringmap.put(5, "double y@s!");//Wrong
            stringmap.put(5, "double M@aybe?");//Wrong
            stringmap.put(5, "char pot@to");//Wrong
            stringmap.put(5, "char Tom@to");//Wrong
            stringmap.put(5, "char youGot!t");//Wrong
            stringmap.put(5, "char 2yumm_y");//Wrong
            stringmap.put(5, "char char");//Wrong

           //Correct to 2:
            stringmap.put(5, "double myDouble = 2.0;");//Correct
            stringmap.put(5, "double thisDouble = 1.0;");//Correct
            stringmap.put(5, "double yourDouble = 555.555;");//Correct
            stringmap.put(5, "double his_Double = 222.2;");//Correct
            stringmap.put(5, "double her_Double = 10.10;");//Correct
            stringmap.put(5, "char myChar = 'a';");//Correct
            stringmap.put(5, "char thisChar = '2';");//Correct
            stringmap.put(5, "char yourChar = 'c';");//Correct
            stringmap.put(5, "char his_Char = '@';");//Correct
            stringmap.put(5, "char her_Char = '!';");//Correct
            stringmap.put(5, "int myInt = 1;");//Correct
            stringmap.put(5, "int thisInt = 5000020202;");//Correct
            stringmap.put(5, "int yourInt = 20;");//Correct
            stringmap.put(5, "int his_Int = 202020;");//Correct
            stringmap.put(5, "int her_Int = 1101;");//Correct
            stringmap.put(5, "string myString = \"dog\";");//Correct
            stringmap.put(5, "string thisString =  \"Nooooo!\";");//Correct
            stringmap.put(5, "string yourString =  \"@\";"); //Correct
            stringmap.put(5, "string his_String =  \"A\";");//Correct
            stringmap.put(5, "string her_String = \"poop\";");//Correct

            //Wrong to 2:
            stringmap.put(5, "double myDouble = 2;");//Wrong
            stringmap.put(5, "double thisDouble = \"1.0\";");//Wrong
            stringmap.put(5, "double yourDouble = 555;");//Wrong
            stringmap.put(5, "double his_Double = '2';");//Wrong
            stringmap.put(5, "double her_Double = \"yes\";");//Wrong
            stringmap.put(5, "char myChar = 2;");//Wrong
            stringmap.put(5, "char thisChar = 9000;");//Wrong
            stringmap.put(5, "char yourChar = a;");//Wrong
            stringmap.put(5, "char his_Char = \"poop\";");//Wrong
            stringmap.put(5, "char her_Char = 'tomato';");//Wrong
            stringmap.put(5, "int myInt = 11.1;");//Wrong
            stringmap.put(5, "int thisInt = 5000020202.202047;");//Wrong
            stringmap.put(5, "int yourInt = \"  \";");//Wrong
            stringmap.put(5, "int his_Int = '11';");//Wrong
            stringmap.put(5, "int her_Int = \"1101\";");//Wrong
            stringmap.put(5, "string myString = poop;");//Wrong
            stringmap.put(5, "string thisString = 11;");//Wrong
            stringmap.put(5, "string yourString = 'A';"); //Wrong
            stringmap.put(5, "string his_String =  is this is a string?;");//Wrong
            stringmap.put(5, "string her_String =  2.222;");//Wrong

            generaterandom(); // Set the current string to an intitial value.
        }

        public void generaterandom() // generates a random key used in the stringbucket
        {
            Random myrandom = new Random();
            CurrentString = myrandom.nextInt(50) + 1;
        }
    }
}//end of class
