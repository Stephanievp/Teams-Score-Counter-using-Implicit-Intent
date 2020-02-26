package com.example.teamsscorecounterexplicit_intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import static android.net.Uri.parse;

public class WinnerActivity extends AppCompatActivity {

    public static final String TAG = "WinnerActivity";
    private static final String MESSAGE = "message";
    public TextView winner_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
        Log.d(TAG, "inside of onCreate method of WinnerActivity");

        winner_result = (TextView) findViewById(R.id.winner_result);
        Intent intent = getIntent();
        String winner = intent.getStringExtra(MainActivity.RESULT);
        winner_result.setText(winner);

    }

    public void makeCall(View view) {
        Log.d(TAG, "inside of makeCall method of WinnerActivity");

        Intent intent = new Intent(Intent.ACTION_DIAL);
        if(intent.resolveActivity( getPackageManager() ) != null){
            startActivity(intent);
        } else{
            Log.d(TAG, "could not makeCall");
        }

        Log.d(TAG, "end of makeCall method of WinnerActivity");
    }

    public void sendMessage(View view) {
        Log.d(TAG, "inside of sendMessage method of WinnerActivity");

        String msg = winner_result.getText().toString();

        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Complete Action using: ")
                .setText(msg)
                .startChooser();

        Log.d(TAG, "end of sendMessage method of WinnerActivity");
    }

    public void findLocations(View view) {
        Log.d(TAG, "inside of findLocations method of WinnerActivity");

        Uri addressUri = Uri.parse("geo:0,0?q=basketball near me");
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
        if(intent.resolveActivity( getPackageManager() ) != null){
            startActivity(intent);
        } else{
            Log.d(TAG, "could not handle findLocation");
        }
        
        Log.d(TAG, "end of findLocations method of WinnerActivity");
    }
}
