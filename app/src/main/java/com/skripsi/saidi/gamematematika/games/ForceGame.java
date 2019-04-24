package com.skripsi.saidi.gamematematika.games;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.skripsi.saidi.gamematematika.Common;
import com.skripsi.saidi.gamematematika.GameAnchor;
import com.skripsi.saidi.gamematematika.GamePreStart;
import com.skripsi.saidi.gamematematika.NameListener;
import com.skripsi.saidi.gamematematika.R;
import com.skripsi.saidi.gamematematika.controller.GameController;

import java.util.Random;

public class ForceGame extends AppCompatActivity {

    /*
    https://www.baeldung.com/java-math-pow
    resource
     */

    int forceNumber, clueNumber;
    int questionNumber;
    int numberClicked=1;

    FloatingActionButton fab;

    Random rand = new Random();

    TextView questionTv, clueTv, answerTv, totalSoal;
    ImageView imageView;

    GameController gameController = new GameController();

    int soal, score;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_force);


        totalSoal = findViewById(R.id.totalSoalPangkat);
        questionTv = findViewById(R.id.questionForce);
        clueTv = findViewById(R.id.clueForce);
        answerTv = findViewById(R.id.answerForce);
        fab = findViewById(R.id.btn_checkForce);

        // TODO Show soal & set totalSoal Textview to the var
        String stringSoal = String.valueOf(GameController.soal);

        score = Integer.valueOf(GameController.score);
        soal = Integer.valueOf(stringSoal);
        totalSoal.setText("Soal ke - "+ stringSoal + "\n Score : " + score);

        imageView = findViewById(R.id.imgAsButton);

        clueNumber = rand.nextInt(7)+2;
        forceNumber = rand.nextInt(3)+2;

        questionNumber = (int) Math.pow(clueNumber,forceNumber);

        fab.setVisibility(View.INVISIBLE);

        clueTv.setText(clueNumber+"");
        questionTv.setText(" = "+questionNumber);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClicked++;

                fab.setVisibility(View.VISIBLE);
                answerTv.setText(numberClicked+"");
            }
        });

        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                numberClicked = 1;
                answerTv.setText("?");
                fab.setVisibility(View.INVISIBLE);
                return true;

            }
        });

        // Jika jawaban Benar
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numberClicked == forceNumber){
                    // TODO tambah soal dan tambah socre jika benar
                    gameController.setSoal(soal+1);
                    gameController.setScore(score+10);

                    Toast.makeText(getApplicationContext(), "Jawaban benar", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), GameAnchor.class);
                    startActivity(intent);

                    finish();
                }
            }
        });

    }
}
