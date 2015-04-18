package com.example.zach.catdogwalrus;
import android.support.v4.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Zach on 2/11/2015.
 */
public class Score_alert_fragment_variableminigame extends DialogFragment {

    // two buttons on the window
    Button againbutton;
    Button lessonbutton;
    mylistener thelistener;
    TextView yscore;
    TextView hscore;
    int h; // holds number for high score
    int y; // holds number for your score
    public Score_alert_fragment_variableminigame() {
        // Required empty public constructor.
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v;
        v = inflater.inflate(R.layout.score_alert, container, false);
        againbutton = (Button) v.findViewById(R.id.alert_playagainbutton);
        lessonbutton = (Button) v.findViewById(R.id.alert_lessonselectbutton);
        yscore= (TextView) v.findViewById(R.id.alert_yourscore);
        hscore= (TextView) v.findViewById(R.id.alert_highscore);
        yscore.setText("Your score: " + y);
        hscore.setText("High score: "+ h);
        thelistener = new mylistener();
        againbutton.setOnClickListener(thelistener);
        lessonbutton.setOnClickListener(thelistener);
        getDialog().setTitle("Game finished!");
        getDialog().setCanceledOnTouchOutside(false); // prevent exit on click outside of dialog
        getDialog().setCancelable(false); // prevent exit on back button
        return v;
    }

    public class mylistener implements OnClickListener {

        public void onClick(View v)
        {
            if (v == againbutton)
            {

                Intent again = new Intent(v.getContext(), VariableMinigame.class);
                startActivity(again);
            }
            else if (v == lessonbutton)
            {
                Intent lesson = new Intent(v.getContext(), Chapter1.class);
                startActivity(lesson);
            }

         }

    }

}
