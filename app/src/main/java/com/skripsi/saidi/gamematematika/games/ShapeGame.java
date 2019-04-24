package com.skripsi.saidi.gamematematika.games;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.skripsi.saidi.gamematematika.Common;
import com.skripsi.saidi.gamematematika.GameAnchor;
import com.skripsi.saidi.gamematematika.NameListener;
import com.skripsi.saidi.gamematematika.R;
import com.skripsi.saidi.gamematematika.controller.GameController;

import java.util.Random;

public class ShapeGame extends AppCompatActivity {

    Random rand = new Random();

    int chooseShape = rand.nextInt(3);
    int chooseType = rand.nextInt(1);

    int var1 = rand.nextInt(15)+5;
    int var2 = rand.nextInt(16)+6;

    int correctAnswer;

    ImageView imgShape;
    TextView informationShape, totalSoal;
    EditText answer;

    Button btnSubmit;
    int soal, score;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_shape);

        totalSoal = findViewById(R.id.totalSoalShape);
        imgShape = findViewById(R.id.imageShape);
        informationShape = findViewById(R.id.questionShape);
        answer = findViewById(R.id.answerShape);
        btnSubmit = findViewById(R.id.submitShape);

        soal = Integer.valueOf(GameController.soal);
        score = Integer.valueOf(GameController.score);

        String StringSoal = String.valueOf(GameController.soal);
        totalSoal.setText("Soal ke - "+ StringSoal + " \n Score : "+ score);

        if(chooseShape == 0){
            // Persegi
            imgShape.setImageResource(R.drawable.persegi);
            if(chooseType == 1){
                // Mencari keliling
                informationShape.setText("Diketahui "
                        +"\n"+"Sisi = "+ var1
                        +"\n"+"Carilah Keliling.");
                // Rumus
                correctAnswer = 4*var1;
            }else {
                // Mencari Luas
                informationShape.setText("Diketahui "
                        +"\n"+"Sisi = "+ var1
                        +"\n"+"Carilah Luas.");
                // Rumus
                correctAnswer = var1*var1;
            }
        } else if (chooseShape == 1){
            // Persegi Panjang
            imgShape.setImageResource(R.drawable.persegi_panjang);
            if(chooseType == 1){
                // Mencari Keliling
                informationShape.setText("Diketahui "
                        +"\n"+"Panjang = "+ var1
                        +"\n"+"Lebar = "+ var2
                        +"\n"+"Carilah Keliling.");
                //Rumus
                correctAnswer = (var1+var2)*2;
            }else {
                // Mencari Luas
                informationShape.setText("Diketahui "
                        +"\n"+"Panjang = "+ var1
                        +"\n"+"Lebar = "+ var2
                        +"\n"+"Carilah Luas.");
                // Rumus
                correctAnswer = var1*var2;
            }
        } else if (chooseShape == 2){
            // Segitiga
            imgShape.setImageResource(R.drawable.segitiga);
            if(chooseType == 1){
                // Mencari Keliling
                informationShape.setText("Diketahui "
                        +"\n"+"Sisi = "+ var1
                        +"\n"+"Carilah Keliling.");
                // Rumus
                correctAnswer = var1+var1+var1;
            }else {
                // Mencari Luas
                informationShape.setText("Diketahui "
                        +"\n"+"Alas = "+ var1
                        +"\n"+"Tinggi = "+ var2
                        +"\n"+"Carilah Luas.");
                // Rumus
                correctAnswer = var1*var2/2;
            }
        }

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Answer = answer.getText().toString();
                int answerInt = Integer.parseInt(Answer);
                if(correctAnswer == answerInt){
                    Toast.makeText(getApplicationContext(), "Jawaban benar", Toast.LENGTH_SHORT);

                    GameController gameController = new GameController();
                    gameController.setSoal(soal+1);

                    gameController.setScore(score+10);

                    Intent intent = new Intent(getApplicationContext(), GameAnchor.class);
                    startActivity(intent);

                    finish();

                }else{
                    Toast.makeText(getApplicationContext(), "Jawaban salah", Toast.LENGTH_SHORT);
                    GameController gameController = new GameController();

                    gameController.setSoal(soal+1);

                    Intent intent = new Intent(getApplicationContext(), GameAnchor.class);
                    startActivity(intent);

                    finish();

                }
            }
        });
    }
}
