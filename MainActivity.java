package com.example.teamsscorecounterexplicit_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    public static final String RESULT = "Result";

    private int t1Count, t2Count = 0;
    private TextView t1ShowCount, t2ShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "inside of onCreate method of MainActivity");

        t1ShowCount = (TextView) findViewById(R.id.show_count_team1);
        t2ShowCount = (TextView) findViewById(R.id.show_count_team2);
    }

    public void countUpT1(View view) {
        Log.d(TAG, "Inside of countUpT1 method of MainActivity");

        t1Count++;
        if(t1ShowCount != null){
            t1ShowCount.setText(Integer.toString(t1Count));
        }
        if(t1Count == 5)
            launchWinnerActivity();

    }

    public void countUpT2(View view) {
        Log.d(TAG, "Inside of countUpT2 method of MainActivity");

        t2Count++;
        if(t2ShowCount != null){
            t2ShowCount.setText(Integer.toString(t2Count));
        }
        if(t2Count == 5)
            launchWinnerActivity();
    }

    private void launchWinnerActivity() {
        Log.d(TAG, "inside of launchWinnerActivity method of MainActivity");
        Intent intent = new Intent(this, WinnerActivity.class);
        int points;
        if(t1Count == 5){
            points = t1Count - t2Count;
            intent.putExtra(RESULT, "Team 1\n" +
                    "\n They won by " + points + " points");
            startActivity(intent);
        }
        else {
            points = t2Count - t1Count;
            intent.putExtra(RESULT, "Team 2\n" +
                    "\n They won by " + points + " points");
            startActivity(intent);
        }

    }

    public void reset(View view) {
        Log.d(TAG, "inside of reset method in MainActivity");
        t1Count = 0;
        if(t1ShowCount != null){
            t1ShowCount.setText(Integer.toString(t1Count));
        }
        t2Count = 0;
        if(t2ShowCount != null){
            t2ShowCount.setText(Integer.toString(t2Count));
        }
    }
}
