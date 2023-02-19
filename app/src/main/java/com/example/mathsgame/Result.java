package com.example.mathsgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    TextView result;
    Button exit;
    Button playAgain;
    int addScore;
    int subScore;
    int mulScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        result = findViewById(R.id.finalScore);
        exit = findViewById(R.id.buttonExit);
        playAgain = findViewById(R.id.buttonAgain);

        //For addition page
        Intent intent = getIntent();
        addScore = intent.getIntExtra( "Score",0);
        String userAddScore = String.valueOf(addScore);
        result.setText("Your Score: " + userAddScore);

        //For subtraction page
        Intent intentSubtract = getIntent();
        subScore = intentSubtract.getIntExtra("subscore", 0);
        String userSubScore = String.valueOf(subScore);
        result.setText("YourScore " + userSubScore);

        //For Multiplication page
        Intent intentMultiply = getIntent();
        mulScore = intentMultiply.getIntExtra("mulscore", 0);
        String userMulScore = String.valueOf(mulScore);
        result.setText("Your Score " + userMulScore);



        playAgain.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Result.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });


    }
}