package com.example.android.court_counter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int score_teamA = 0, score_teamB = 0;
    boolean start = false;
    AlertDialog.Builder dlgAlert;
    LinearLayout ll;
    TextView time_TextView;
    Button start_button;


    private int nCounter = 60;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
        dlgAlert.setMessage("this is a one minute game..team with the higher score wins");
        dlgAlert.setTitle("App Title");
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
        ll = (LinearLayout) findViewById(R.id.owns_team_1_2);
        time_TextView = (TextView) findViewById(R.id.timer);
        start_button = (Button) findViewById(R.id.button_start);
    }

    public void display() {
        TextView tv = (TextView) (findViewById(R.id.scoreA));
        tv.setText(String.valueOf(score_teamA));
        tv = (TextView) (findViewById(R.id.scoreB));
        tv.setText(String.valueOf(score_teamB));
    }

    //returns the content of textview of team a
    public String getTextA() {
        TextView tv = findViewById(R.id.scoreA);
        String content = tv.getText().toString();
        return content;
    }

    //returns the content of textview of team b
    public String getTextB() {
        TextView tv = findViewById(R.id.scoreB);
        String content = tv.getText().toString();
        return content;
    }

    public void three(View b) {

//        LinearLayout ll = (LinearLayout) b.getParent();
        //if(format("%d", ((Button) b).getId()) =="teamA_3"){
        if ((Button) b == findViewById(R.id.teamA_3)) {
            score_teamA = score_teamA + 3;
            display();
        } else {
            score_teamB = score_teamB + 3;
            display();
        }
    }

    public void two(View b) {
        //   LinearLayout ll = (LinearLayout) b.getParent();

        if ((Button) b == findViewById(R.id.teamA_2)) {
            score_teamA = score_teamA + 2;
            display();

        } else {
            score_teamB = score_teamB + 2;
            display();

        }

    }

    public void free(View b) {
        //  LinearLayout ll = (LinearLayout) b.getParent();

        if ((Button) b == findViewById(R.id.teamA_free)) {
            score_teamA++;
            display();

        } else {
            score_teamB++;
            display();
        }

    }

    public void reset(View v) {
        score_teamA = 0;
        score_teamB = 0;
        display();
        // ll.setVisibility(View.INVISIBLE);
        //time_TextView.setVisibility(View.INVISIBLE);
    }


    public void set_visible(View v) {

        // ll.setVisibility(View.VISIBLE);

        //time_TextView.setVisibility(View.VISIBLE);
        // start_button.setVisibility(View.GONE);
        // score_teamA = 0;
        //score_teamB = 0;
        display();
        // ll.setVisibility(View.VISIBLE);
        //time_TextView.setVisibility(View.VISIBLE);
        //start the count
        try {
            timer_60();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    boolean status_victory=false;
    public void victory(){
        if(!status_victory) {
            if (score_teamA > score_teamB) {
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, "team A wins",Toast.LENGTH_LONG);
                toast.show();
            } else if (score_teamA == score_teamB) {
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, "ITS A TIE",Toast.LENGTH_LONG);
                toast.show();
            } else {
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, "team B wins",Toast.LENGTH_LONG);
                toast.show();
            }
            victory();
        }
        else{
            if (score_teamA > score_teamB) {
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, "team A wins",Toast.LENGTH_LONG);
                toast.show();
            } else if (score_teamA == score_teamB) {
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, "ITS A TIE", Toast.LENGTH_LONG);
                toast.show();
            } else {
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, "team B wins",Toast.LENGTH_LONG);
                toast.show();
            }
        }
    }

    public boolean call = true;
    private int count = 1;

    public void timer_60() throws InterruptedException {
        int i = 60;
        //   call = true;
        final TextView tv = (TextView) findViewById(R.id.timer);
        int duration = Toast.LENGTH_LONG;

        // Thread t=new Thread();

        /*while (i >= 0) {
            tv.setText(String.format("%d", --i));
            //  android.os.SystemClock.sleep(100);



         /*the user is enable to use buttons
          try {
               t.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        Time obj=new Time();

        if (call) {
            count = 0;
            call = false;
            android.os.CountDownTimer cdt = new android.os.CountDownTimer(61000, 1000) {

                public void onTick(long millisUntilFinished) {
                    tv.setText("seconds :" + millisUntilFinished / 1000);
                    //here you can have your logic to set text to edittext
                }

                public void onFinish() {
                    tv.setText("FINISH");
                }

            }.start();
            i=60;

            /*
            while(!call) {
                if(tv.getText()=="FINISH"){
                    if (score_teamA > score_teamB) {
                        Context context = getApplicationContext();
                        Toast toast = Toast.makeText(context, "team A wins", duration);
                        toast.show();
                    } else if (score_teamA == score_teamB) {
                        Context context = getApplicationContext();
                        Toast toast = Toast.makeText(context, "ITS A TIE", duration);
                        toast.show();
                    } else {
                        Context context = getApplicationContext();
                        Toast toast = Toast.makeText(context, "team B wins", duration);
                        toast.show();
                    }

                }

                //tv.setText(String.format("60"));

               // call = true;

            }*/
            if (score_teamA > score_teamB) {
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, "team A wins", duration);
                toast.show();
            } else if (score_teamA == score_teamB) {
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, "ITS A TIE", duration);
                toast.show();
            } else {
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, "team B wins", duration);
                toast.show();
            }
            call = true;

        }
    }
}