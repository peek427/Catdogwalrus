package com.example.zach.catdogwalrus;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Minigame_fragment extends Fragment implements View.OnClickListener {

    Button backbutton;
    View view;

    public Minigame_fragment() {
        // Required empty public constructor.
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.minigame_fragment_layout, container, false);
        backbutton = (Button) view.findViewById(R.id.BackButton);
        backbutton.setOnClickListener(this);
        // Inflate the layout for this fragment
        return view;
    }

   public void onClick(View v) {
       if (v == backbutton) {
           Intent tolessonselect = new Intent(v.getContext(), Chapter1.class);
           startActivity(tolessonselect);
       }
   }

}
