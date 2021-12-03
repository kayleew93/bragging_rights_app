package com.example.braggingrights;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StatisticsMainActivity extends AppCompatActivity {


    public void clickViewStatsByGame(View view) {
        startActivity(new Intent(StatisticsMainActivity.this, ViewStatsByGameActivity.class));
    }

    public void clickViewStatsByPlayer(View view) {
        startActivity(new Intent(StatisticsMainActivity.this, ViewStatsByPlayerActivity.class));
    }
}