package com.example.mathsgame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

public class GameSubtract extends AppCompatActivity {
    TextView score;
    TextView life;
    TextView time;
    TextView question;
    EditText answer;

    Button ok;
    Button next;
    Random random = new Random();
    int number1;
    int number2;
    int userAnswer;
    int realAnswer;
    int userScore = 0;
    int userLife = 3;
    CountDownTimer timer;
    private static final long START_TIMER_IN_MILLIES = 60000;
    Boolean timerRunning;
    long time_left_in_millies = START_TIMER_IN_MILLIES ;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_subtract);
        score = findViewById(R.id.textViewScore);
        life = findViewById(R.id.textViewLives);
        time = findViewById(R.id.textViewTimer);
        question = findViewById(R.id.textViewQuestion);
        answer = findViewById(R.id.editTextAnswer);
        ok = findViewById(R.id.buttonOk);
        next = findViewById(R.id.buttonNext);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userAnswer = Integer.valueOf(answer.getText().toString());
                if(userAnswer==realAnswer){
                    userScore = userScore + 10;
                    score.setText(userScore + "");
                    question.setText("Congratulations correct answer!");

                }else{
                    userLife = userLife - 1;
                    life.setText("" + userLife);
                    question.setText("Wrong Answer!");
                }

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer.setText("");
                gameContinue();
                resetTimer();

                if(userLife == 0){
                    Toast.makeText(getApplicationContext(),"game Over",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(GameSubtract.this,Result.class);
                    intent.putExtra("sub score",userScore);
                    startActivity(intent);
                    finish();
                }else{
                    gameContinue();

                }
            }
        });
        gameContinue();



    }
    public void gameContinue(){
        number1 = random.nextInt(100);
        number2 = random.nextInt(100);
        question.setText(number1 + " - " + number2);
        realAnswer = number1 - number2;
        startTimer();

    }
    public void startTimer(){
        timer = new CountDownTimer(time_left_in_millies,1000) {
            @Override
            public void onTick(long millesUntilFinish) {
                time_left_in_millies = millesUntilFinish;
                updateText();

            }

            @Override
            public void onFinish() {
                timerRunning = false;
                pauseTimer();
                resetTimer();
                updateText();
                userLife = userLife - 1;
                life.setText("" +userLife);
                question.setText("Time UP!");
            }
        }.start();
        timerRunning = true;
    }

    public void updateText(){
        int second = (int) (time_left_in_millies / 1000) % 60;
        String time_left = String.format(Locale.getDefault(),"%02d",second);
        time.setText(time_left);

    }
    public void pauseTimer(){
        timer.cancel();
        timerRunning = false;



    }
    public void resetTimer(){
        time_left_in_millies = START_TIMER_IN_MILLIES;
        updateText();

    }
}


