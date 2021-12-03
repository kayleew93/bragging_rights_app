package com.example.braggingrights;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.AWSDataStorePlugin;
import com.amplifyframework.datastore.generated.model.Player;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {
            //Amplify.addPlugin(new AWSApiPlugin()); // UNCOMMENT this line once backend is deployed
            Amplify.addPlugin(new AWSDataStorePlugin());
            Amplify.configure(getApplicationContext());
            Log.i("Amplify", "Initialized Amplify");
        } catch (
        AmplifyException error) {
            Log.e("Amplify", "Could not initialize Amplify", error);
        }

        Player item = Player.builder()
                .fullName("Lorem ipsum dolor sit amet")
                .nickname("Lorem ipsum dolor sit amet")
                .totalGames(1020)
                .gamesWon(1020)
                .build();
        Amplify.DataStore.save(
                item,
                success -> Log.i("Amplify", "Saved item: " + success.item().getId()),
                error -> Log.e("Amplify", "Could not save item to DataStore", error)
        );

    }

    public void clickCreateGame(View view) {
        // Send user to Create Game Activity
        startActivity(new Intent(MainActivity.this, CreateGameActivity.class));
    }

    public void clickCreateLocalPlayer(View view) {
        // Send user to Create Local Player Activity
        startActivity(new Intent(MainActivity.this, CreateLocalPlayerActivity.class));
    }

    public void clickViewStatistics(View view) {
        // Send user to View Statistics Activity
        startActivity(new Intent(MainActivity.this, StatisticsMainActivity.class));
    }
}