package com.example.dices;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button throwDice;

    private TextView r1;
    private TextView r2;
    private TextView r3;
    private TextView r4;
    private TextView r5;

    private TextView rollResult;
    private TextView gameResult;
    private TextView throwCount;

    private Button resetButton;

    private TextView[] rolls = new TextView[5];
    private int[] diceRolls = new int[5];
    private int rollResultCounter = 0;
    private int gameResultCounter = 0;
    private int throwCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        throwDice = findViewById(R.id.throwDice);
        r1 = findViewById(R.id.roll1);
        r2 = findViewById(R.id.roll2);
        r3 = findViewById(R.id.roll3);
        r4 = findViewById(R.id.roll4);
        r5 = findViewById(R.id.roll5);
        rollResult = findViewById(R.id.rollResult);
        gameResult = findViewById(R.id.gameResult);
        throwCount = findViewById(R.id.throwCount);
        resetButton = findViewById(R.id.resetButton);

        rolls[0] = r1;
        rolls[1] = r2;
        rolls[2] = r3;
        rolls[3] = r4;
        rolls[4] = r5;

        throwDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollDice();
            }
        });
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });
    }
    public void rollDice() {
        Random rand = new Random();
        int rollsCounter = 0;
        for(int i = 0; i < rolls.length; i++) {
            diceRolls[i] = rand.nextInt(6)+1;
            rollsCounter += diceRolls[i];
        }
        rollResultCounter = rollsCounter;
        gameResultCounter += rollsCounter;
        rollResult.setText("Wynik tego losowania: " + rollResultCounter);
        updateScore(gameResultCounter);
        updateRollCount();
        displayDiceResult(diceRolls);
    }
    public void resetGame() {
        for(int i = 0; i < rolls.length; i++) {
            rolls[i].setText(" ? ");
        }
        rollResultCounter = 0;
        gameResultCounter = 0;
        throwCounter = 0;
        rollResult.setText("Wynik tego losowania: " + rollResultCounter);
        updateScore(gameResultCounter);
        throwCount.setText("Liczba rzutów: " + throwCounter);
    }
    public void updateScore(int newScore) {
        gameResult.setText("Wynik gry: " + newScore);
    }
    public void updateRollCount() {
        throwCounter++;
        throwCount.setText("Liczba rzutów: " + throwCounter);
    }
    public void displayDiceResult(int[] diceResult) {
        for(int i = 0; i < rolls.length; i++) {
            rolls[i].setText(String.valueOf(diceResult[i]));
        }
    }
}