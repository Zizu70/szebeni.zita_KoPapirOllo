package com.example.kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.Button;
import android.graphics.Color;
import android.content.DialogInterface;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewPlayer;
    private TextView textViewTe;
    private ImageView imageViewRandom;
    private TextView textViewGep;

    private TextView textViewResult;
    private TextView textViewPlayer;
    private TextView textViewRandom;

    private Button buttonRock;
    private Button buttonPaper;
    private Button buttonSciccors;

    private int randomNumber;
    private int playerNumber;

    private int playerScore = 0;
    private int randomScore = 0;

    private AlertDialog.Builder alertDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        resetGame();

        buttonRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageViewPlayer.setImageResource(R.drawable.rock);
                playerNumber = 1;
                newGame();
            }
        });
        buttonPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageViewPlayer.setImageResource(R.drawable.paper);
                playerNumber = 2;
                newGame();
            }
        });
        buttonSciccors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageViewPlayer.setImageResource(R.drawable.scissors);
                playerNumber = 3;
                newGame();
            }
        });
    }

    public void newGame() {
        Random random = new Random();
        randomNumber = random.nextInt(3) + 1;
        if (randomNumber == 1) {
            imageViewRandom.setImageResource(R.drawable.rock);
        } else if (randomNumber == 2) {
            imageViewRandom.setImageResource(R.drawable.paper);
        } else {
            imageViewRandom.setImageResource(R.drawable.scissors);
        }
        hitWatcher();
    }

    public void hitWatcher() {
        if (randomNumber == 1 && playerNumber == 2) {
            Toast.makeText(MainActivity.this, "TE nyertél!", Toast.LENGTH_SHORT).show();
            playerScore ++;
            textViewPlayer.setText("Ember: " + playerScore);
        } else if (randomNumber == 1 && playerNumber == 3) {
            Toast.makeText(MainActivity.this, "GÉP nyert!", Toast.LENGTH_SHORT).show();
            randomScore ++;
            textViewRandom.setText(" Computer: " + randomScore);
        } else if (randomNumber == 2 && playerNumber == 3) {
            Toast.makeText(MainActivity.this, "TE nyertél!!", Toast.LENGTH_SHORT).show();
            playerScore ++;
            textViewPlayer.setText("Ember: " + playerScore);
        } else if (randomNumber == 2 && playerNumber == 1) {
            Toast.makeText(MainActivity.this, "GÉP nyert!", Toast.LENGTH_SHORT).show();
            randomScore ++;
            textViewRandom.setText(" Computer: " + randomScore);
        } else if (randomNumber == 3 && playerNumber == 1) {
            Toast.makeText(MainActivity.this, "TE nyertél!", Toast.LENGTH_SHORT).show();
            playerScore ++;
            textViewPlayer.setText("Ember: " + playerScore);
        } else if (randomNumber == 3 && playerNumber == 2) {
            Toast.makeText(MainActivity.this, "GÉP nyert!", Toast.LENGTH_SHORT).show();
            randomScore ++;
            textViewRandom.setText(" Computer: " + randomScore);
        } else {
                Toast.makeText(MainActivity.this, "Egyezés!", Toast.LENGTH_SHORT).show();
        }
        gameOver();
    }

    public void gameOver() {
        if (playerScore == 2 || randomScore == 2) {
            alertDialog.setTitle(playerScore == 2 ? "Győzelem!" : "Vereség");
            alertDialog.create();
            alertDialog.show();
        }
    }

    public void resetGame() {
        imageViewPlayer.setImageResource(R.drawable.rock);
        imageViewRandom.setImageResource(R.drawable.rock);
        randomScore = 0;
        playerScore = 0;
        textViewPlayer.setText("Ember: " + playerScore);
        textViewRandom.setText(" Computer: " + randomScore);
        Toast.makeText(MainActivity.this, "Új játék indul!", Toast.LENGTH_SHORT).show();
    }

    public void init() {
        imageViewPlayer = findViewById(R.id.imageViewPlayer);
        textViewTe = findViewById(R.id.textViewTe);
        imageViewRandom = findViewById(R.id.imageViewRandom);
        textViewGep = findViewById(R.id.textViewGep);

        textViewResult = findViewById(R.id.textViewResult);
        textViewPlayer = findViewById(R.id.textViewPlayer);
        textViewRandom = findViewById(R.id.textViewRandom);

        buttonRock = findViewById(R.id.buttonRock);
        buttonPaper = findViewById(R.id.buttonPaper);
        buttonSciccors = findViewById(R.id.buttonSciccors);

        Random random = new Random();
        randomNumber = random.nextInt(4);
        playerNumber = 0;

        alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog
                .setMessage("Szeretne új játékot játszani?")
                .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        resetGame();
                    }
                })
                .setCancelable(false)
                .create();
    }
}