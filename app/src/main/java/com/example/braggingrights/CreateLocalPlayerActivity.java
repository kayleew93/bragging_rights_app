package com.example.braggingrights;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

public class CreateLocalPlayerActivity extends AppCompatActivity {

    private static final String TAG = "CreateLocalPlayerActivity";
    // Variables
    EditText fullName, pNickname, phoneNumber;
    int gender;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_local_player);

        // hooks all xml elements in activity_create_local_player.xml
        fullName = findViewById(R.id.playerName);
        pNickname = findViewById(R.id.playerNickname);
        phoneNumber = findViewById(R.id.phoneNumber);
        db = new DBHelper(this);


    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.male:
                if (checked)
                    gender = 0;
                    break;
            case R.id.female:
                if (checked)
                    gender = 1;
                    break;
        }
    }


    public void selectAvatar(View view) {
        startActivity(new Intent(CreateLocalPlayerActivity.this, SelectAvatar.class));
    }


        public void clickCreatePlayer(View view) {
        // Test SQLite https://www.youtube.com/watch?v=9t8VVWebRFM
        String nameTXT = fullName.getText().toString();
        String pNicknameTXT = pNickname.getText().toString();
        String phoneNumberTXT = phoneNumber.getText().toString();
        int phoneNumberINT = Integer.parseInt(phoneNumberTXT);
        int gamesWon = 0;
        int totalGames = 0;


        Boolean checkinsertdata = db.insertPlayerDetails(gamesWon, gender, nameTXT, pNicknameTXT, phoneNumberINT, totalGames);
                if (checkinsertdata==true)
                    Toast.makeText(CreateLocalPlayerActivity.this, "New Player Inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(CreateLocalPlayerActivity.this, "Error: New Player Not Inserted", Toast.LENGTH_LONG).show();

         // Send user to back to Main
        startActivity(new Intent(CreateLocalPlayerActivity.this, MainActivity.class));
 }
}