package com.skripsi.saidi.gamematematika.games;

import android.content.Intent;
import android.graphics.Path;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.skripsi.saidi.gamematematika.Common;
import com.skripsi.saidi.gamematematika.GameAnchor;
import com.skripsi.saidi.gamematematika.NameListener;
import com.skripsi.saidi.gamematematika.R;
import com.skripsi.saidi.gamematematika.controller.GameController;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class OperationGame extends AppCompatActivity{

    private static final int[] idBtnArray = {R.id.answerA, R.id.answerB,
            R.id.answerC, R.id.answerD};

    private Button[] buttons = new Button[idBtnArray.length];

    Random rand = new Random();
    int var1,var2;
    int result;
    int choose;
    int i;
    int soal, score;

    String Operation;
    GameController gameController = new GameController();

    TextView question, totalSoal;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_operation);

        question = findViewById(R.id.question);

        var1 = rand.nextInt(40)+1;
        var2 = rand.nextInt(50)+1;


        totalSoal = findViewById(R.id.totalSoalOp);
        soal = Integer.valueOf(GameController.soal);
        score = Integer.valueOf(GameController.score);

        String StringSoalOp = String.valueOf(GameController.soal);
        totalSoal.setText("Soal ke - "+ StringSoalOp + "\n Score : "+ score);

        choose = rand.nextInt(4);

        switch (choose){
            case 0: Operation = "+";
            result = var1+var2;
            break;
            case 1: Operation = "-";
            result = var1-var2;
            break;
            case 2: Operation = "*";
            result = var1*var2;
            break;
            case 3: Operation = "/";
            result = var1/var2;
            break;
        }


        question.setText(var1+" "+Operation+" "+var2+" = ?");

        shuffleArray(idBtnArray);

        //Assigning in array button
        for(i=0; i<idBtnArray.length;i++){
            buttons[i] = findViewById(idBtnArray[i]);
            for(int j=0; j<idBtnArray.length; j++){
                if(j <= 0){
                    buttons[j].setText(result+"");
                } else if(i==1){
                    buttons[i].setText(result+10-var2+"");
                } else if(i==2){
                    buttons[i].setText(result-var1+"");
                } else if(i==3){
                    buttons[i].setText(var1*3-var2+"");
                }

            }

            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button b = (Button) v;
                    String btnText = b.getText().toString();
                    int btnTextInt = Integer.parseInt(btnText);
                    if(result == btnTextInt){
                        Toast.makeText(getApplicationContext(), "Jawaban benar", Toast.LENGTH_SHORT).show();
                        gameController.setSoal(soal+1);
                        gameController.setScore(score+10);
                        Intent intent = new Intent(getApplicationContext(), GameAnchor.class);
                        startActivity(intent);

                        finish();

                    }else {
                        GameController gameController = new GameController();
                        Toast.makeText(getApplicationContext(), "Jawaban salah", Toast.LENGTH_SHORT).show();
                        gameController.setSoal(soal+1);

                        Intent intent = new Intent(getApplicationContext(), GameAnchor.class);
                        startActivity(intent);

                        finish();
                    }
                }
            });
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void shuffleArray(int[] ar){
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

}
