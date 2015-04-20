

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
        // back is clicked on the first page, it returns to chapter select.  When we figure
        // out the lesson and when to change the code, I think we can just change the text view
        // in the code fragment with a Bundle, but I haven't implemented that yet.
        @Override
        public void onClick(View v)
        {
            if (v == next_button)
            {
                counter++;
                switch(counter){
                    case 2: lessonText.setText(R.string.lesson1_3_2); break;
                    case 3: lessonText.setText(R.string.lesson1_3_3);
                        break;
                    case 4:  Intent toGame = new Intent(v.getContext(), ControlMinigame.class);
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
                    case 3: lessonText.setText(getResources().getString(R.string.lesson1_3_3));
                        codeText.setText(R.string.code1_2_1);
                        break;
                }
            }

        }
    }


