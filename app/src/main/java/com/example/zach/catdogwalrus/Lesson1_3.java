

    package com.example.zach.catdogwalrus;

    import android.content.Intent;
    import android.os.Bundle;
    import android.support.v7.app.ActionBarActivity;
    import android.view.Menu;
    import android.view.MenuItem;
    import android.view.View;
    import android.view.View.OnClickListener;
    import android.widget.Button;
    import android.widget.TextView;


    public class Lesson1_3 extends ActionBarActivity implements OnClickListener {

        private Button next_button;
        private Button back_button;
        int counter = 1;
        TextView codeText;
        TextView lessonText;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.lesson_layout);

            codeText = (TextView) findViewById(R.id.codeText);
            lessonText = (TextView) findViewById(R.id.lessonText);
            lessonText.setText(R.string.lesson1_3_1);
            next_button = (Button) findViewById(R.id.next_button);
            next_button.setOnClickListener(this);
            back_button = (Button) findViewById(R.id.back_button);
            back_button.setOnClickListener(this);


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


        // Handles the back and next button.  The counter keeps track of which page of the
        // lesson its on.  When next is clicked on the last page, the game launches, and when
        // back is clicked on the first page, it returns to chapter select.
        @Override
        public void onClick(View v)
        {
            if (v == next_button)
            {
                counter++;
                switch(counter){
                    case 2: lessonText.setText(R.string.lesson1_3_2); break;
                    case 3: lessonText.setText(R.string.lesson1_3_3);
                        codeText.setText(R.string.code1_3_1);
                        break;
                    case 4:  lessonText.setText(getResources().getString(R.string.lesson1_3_4)); break;
                    case 5: lessonText.setText(getResources().getString(R.string.lesson1_3_5)); break;
                    case 6: lessonText.setText(getResources().getString(R.string.lesson1_3_6)); break;
                    case 7: lessonText.setText(getResources().getString(R.string.lesson1_3_7)); break;
                    case 8: lessonText.setText(getResources().getString(R.string.lesson1_3_8));
                        codeText.setText(R.string.code1_3_2);
                        break;
                    case 9: lessonText.setText(getResources().getString(R.string.lesson1_3_9)); break;
                    case 10: lessonText.setText(getResources().getString(R.string.lesson1_3_10)); break;
                    case 11: lessonText.setText(getResources().getString(R.string.lesson1_3_11)); break;
                    case 12: lessonText.setText(getResources().getString(R.string.lesson1_3_12));
                        codeText.setText(R.string.code1_3_3);
                        break;
                    case 13: lessonText.setText(getResources().getString(R.string.lesson1_3_13)); break;
                    case 14: lessonText.setText(getResources().getString(R.string.lesson1_3_14));
                        codeText.setText(R.string.code1_3_4);
                        break;
                    case 15: lessonText.setText(getResources().getString(R.string.lesson1_3_15)); break;
                    case 16: lessonText.setText(getResources().getString(R.string.lesson1_3_16)); break;
                    case 17: lessonText.setText(getResources().getString(R.string.lesson1_3_17)); break;
                    case 18: lessonText.setText(getResources().getString(R.string.lesson1_3_18)); break;
                    case 19: lessonText.setText(getResources().getString(R.string.lesson1_3_19)); break;
                    case 20: lessonText.setText(getResources().getString(R.string.lesson1_3_20)); break;
                    case 21: lessonText.setText(getResources().getString(R.string.lesson1_3_21)); break;
                    case 22: lessonText.setText(getResources().getString(R.string.lesson1_3_22)); break;
                    case 23: lessonText.setText(getResources().getString(R.string.lesson1_3_23)); break;
                    case 24: lessonText.setText(getResources().getString(R.string.lesson1_3_24)); break;
                    case 25: lessonText.setText(getResources().getString(R.string.lesson1_3_25)); break;
                    case 26: lessonText.setText(getResources().getString(R.string.lesson1_3_26)); break;
                    case 27: lessonText.setText(getResources().getString(R.string.lesson1_3_27)); break;
                    case 28: lessonText.setText(getResources().getString(R.string.lesson1_3_28)); break;
                    case 29: lessonText.setText(getResources().getString(R.string.lesson1_3_29)); break;
                    case 30: lessonText.setText(getResources().getString(R.string.lesson1_3_30)); break;
                    case 31: lessonText.setText(getResources().getString(R.string.lesson1_3_31)); break;
                    case 32: lessonText.setText(getResources().getString(R.string.lesson1_3_32)); break;
                    case 33: lessonText.setText(getResources().getString(R.string.lesson1_3_33)); break;
                    case 34: lessonText.setText(getResources().getString(R.string.lesson1_3_34)); break;
                    case 35: lessonText.setText(getResources().getString(R.string.lesson1_3_35));
                        codeText.setText(R.string.code1_3_5);
                        break;
                    case 36: lessonText.setText(getResources().getString(R.string.lesson1_3_36)); break;
                    case 37: lessonText.setText(getResources().getString(R.string.lesson1_3_37)); break;
                    case 38: lessonText.setText(getResources().getString(R.string.lesson1_3_38)); break;
                    case 39: lessonText.setText(getResources().getString(R.string.lesson1_3_39)); break;
                    case 40: lessonText.setText(getResources().getString(R.string.lesson1_3_40)); break;
                    case 41: lessonText.setText(getResources().getString(R.string.lesson1_3_41)); break;
                    case 42: lessonText.setText(getResources().getString(R.string.lesson1_3_42));
                        codeText.setText(R.string.code_1_3_6);
                        break;
                    case 43: lessonText.setText(getResources().getString(R.string.lesson1_3_43)); break;
                    case 44: lessonText.setText(getResources().getString(R.string.lesson1_3_44)); break;
                    case 45: lessonText.setText(getResources().getString(R.string.lesson1_3_45)); break;
                    case 46: lessonText.setText(getResources().getString(R.string.lesson1_3_46)); break;
                    case 47: lessonText.setText(getResources().getString(R.string.lesson1_3_47)); break;
                    case 48: lessonText.setText(getResources().getString(R.string.lesson1_3_48));
                        codeText.setText("");
                        break;
                    case 49: lessonText.setText(getResources().getString(R.string.lesson1_3_49)); break;
                    case 50: lessonText.setText(getResources().getString(R.string.lesson1_3_50)); break;
                    case 51: lessonText.setText(getResources().getString(R.string.lesson1_3_51)); break;
                    case 52: lessonText.setText(getResources().getString(R.string.lesson1_3_52)); break;
                    case 53: Intent toGame = new Intent(v.getContext(), ControlMinigame.class);
                    startActivity(toGame); break;
                }
            }
            else if ( v == back_button)
            {
                counter--;
                switch(counter){
                    case 0: Intent toChapter = new Intent(v.getContext(), Chapter1.class);
                        startActivity(toChapter); break;
                    case 1: lessonText.setText(getResources().getString(R.string.lesson1_3_1)); break;
                    case 2: lessonText.setText(getResources().getString(R.string.lesson1_3_2)); break;
                    case 3: lessonText.setText(getResources().getString(R.string.lesson1_3_3)); break;
                    case 4:  lessonText.setText(getResources().getString(R.string.lesson1_3_4)); break;
                    case 5: lessonText.setText(getResources().getString(R.string.lesson1_3_5)); break;
                    case 6: lessonText.setText(getResources().getString(R.string.lesson1_3_6)); break;
                    case 7: lessonText.setText(getResources().getString(R.string.lesson1_3_7));
                        codeText.setText(R.string.code1_3_1);
                        break;
                    case 8: lessonText.setText(getResources().getString(R.string.lesson1_3_8)); break;
                    case 9: lessonText.setText(getResources().getString(R.string.lesson1_3_9)); break;
                    case 10: lessonText.setText(getResources().getString(R.string.lesson1_3_10)); break;
                    case 11: lessonText.setText(getResources().getString(R.string.lesson1_3_11));
                        codeText.setText(R.string.code1_3_2);
                        break;
                    case 12: lessonText.setText(getResources().getString(R.string.lesson1_3_12)); break;
                    case 13: lessonText.setText(getResources().getString(R.string.lesson1_3_13));
                        codeText.setText(R.string.code1_3_3);
                        break;
                    case 14: lessonText.setText(getResources().getString(R.string.lesson1_3_14)); break;
                    case 15: lessonText.setText(getResources().getString(R.string.lesson1_3_15)); break;
                    case 16: lessonText.setText(getResources().getString(R.string.lesson1_3_16)); break;
                    case 17: lessonText.setText(getResources().getString(R.string.lesson1_3_17)); break;
                    case 18: lessonText.setText(getResources().getString(R.string.lesson1_3_18)); break;
                    case 19: lessonText.setText(getResources().getString(R.string.lesson1_3_19)); break;
                    case 20: lessonText.setText(getResources().getString(R.string.lesson1_3_20)); break;
                    case 21: lessonText.setText(getResources().getString(R.string.lesson1_3_21)); break;
                    case 22: lessonText.setText(getResources().getString(R.string.lesson1_3_22)); break;
                    case 23: lessonText.setText(getResources().getString(R.string.lesson1_3_23)); break;
                    case 24: lessonText.setText(getResources().getString(R.string.lesson1_3_24)); break;
                    case 25: lessonText.setText(getResources().getString(R.string.lesson1_3_25)); break;
                    case 26: lessonText.setText(getResources().getString(R.string.lesson1_3_26)); break;
                    case 27: lessonText.setText(getResources().getString(R.string.lesson1_3_27)); break;
                    case 28: lessonText.setText(getResources().getString(R.string.lesson1_3_28)); break;
                    case 29: lessonText.setText(getResources().getString(R.string.lesson1_3_29)); break;
                    case 30: lessonText.setText(getResources().getString(R.string.lesson1_3_30)); break;
                    case 31: lessonText.setText(getResources().getString(R.string.lesson1_3_31)); break;
                    case 32: lessonText.setText(getResources().getString(R.string.lesson1_3_32)); break;
                    case 33: lessonText.setText(getResources().getString(R.string.lesson1_3_33)); break;
                    case 34: lessonText.setText(getResources().getString(R.string.lesson1_3_34));
                        codeText.setText(R.string.code1_3_4);
                        break;
                    case 35: lessonText.setText(getResources().getString(R.string.lesson1_3_35)); break;
                    case 36: lessonText.setText(getResources().getString(R.string.lesson1_3_36)); break;
                    case 37: lessonText.setText(getResources().getString(R.string.lesson1_3_37)); break;
                    case 38: lessonText.setText(getResources().getString(R.string.lesson1_3_38)); break;
                    case 39: lessonText.setText(getResources().getString(R.string.lesson1_3_39)); break;
                    case 40: lessonText.setText(getResources().getString(R.string.lesson1_3_40)); break;
                    case 41: lessonText.setText(getResources().getString(R.string.lesson1_3_41));
                        codeText.setText(R.string.code1_3_5);
                        break;
                    case 42: lessonText.setText(getResources().getString(R.string.lesson1_3_42)); break;
                    case 43: lessonText.setText(getResources().getString(R.string.lesson1_3_43)); break;
                    case 44: lessonText.setText(getResources().getString(R.string.lesson1_3_44)); break;
                    case 45: lessonText.setText(getResources().getString(R.string.lesson1_3_45)); break;
                    case 46: lessonText.setText(getResources().getString(R.string.lesson1_3_46)); break;
                    case 47: lessonText.setText(getResources().getString(R.string.lesson1_3_47));
                        codeText.setText(R.string.code_1_3_6);
                        break;
                    case 48: lessonText.setText(getResources().getString(R.string.lesson1_3_48)); break;
                    case 49: lessonText.setText(getResources().getString(R.string.lesson1_3_49)); break;
                    case 50: lessonText.setText(getResources().getString(R.string.lesson1_3_50)); break;
                    case 51: lessonText.setText(getResources().getString(R.string.lesson1_3_51)); break;
                    case 52: lessonText.setText(getResources().getString(R.string.lesson1_3_52)); break;
                }
            }

        }
    }


