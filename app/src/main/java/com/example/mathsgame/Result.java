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


        if (getIntent().hasExtra("Score") ) {
            addScore = getIntent().getIntExtra("Score", 0);
            result.setText(String.valueOf(addScore));
        }else if(getIntent().hasExtra("sub score")){
            subScore = getIntent().getIntExtra("sub score", 0);
            result.setText(String.valueOf(addScore));
        }else if(getIntent().hasExtra("mul score")){
            mulScore = getIntent().getIntExtra("mul score", 0);
            result.setText(String.valueOf(addScore));
        }



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