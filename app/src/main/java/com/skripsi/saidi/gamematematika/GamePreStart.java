package com.skripsi.saidi.gamematematika;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.skripsi.saidi.gamematematika.controller.GameController;
import com.skripsi.saidi.gamematematika.games.ForceGame;
import com.skripsi.saidi.gamematematika.games.OperationGame;
import com.skripsi.saidi.gamematematika.games.ShapeGame;

import java.util.Random;

public class GamePreStart extends AppCompatActivity implements NameListener {

    Random rand = new Random();
    int n = rand.nextInt(2);

    Button startGame, exit;
    TextView textView;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_prestart);
        startGame = findViewById(R.id.startBtn);
        textView = findViewById(R.id.userTv);

        mAuth = FirebaseAuth.getInstance();
        exit = findViewById(R.id.exit);

//        GameController gameController = new GameController();
//        gameController.setSoal(1);

        FirebaseUser currentUser = mAuth.getCurrentUser();
        String namaPlayer = currentUser.getDisplayName();
        textView.setText("Selamat Datang "+namaPlayer);



        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();

                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GameChooser();
            }
        });
    }


    public void GameChooser(){
        if(n == 0){
            // do operation bilangan
            Intent intent = new Intent(getApplicationContext(), OperationGame.class);
            startActivity(intent);
        } else if(n == 1 ){
            // do pangkat
            Intent intent = new Intent(getApplicationContext(), ForceGame.class);
            startActivity(intent);
        } else if( n == 2){
            // do Bangun datar
            Intent intent = new Intent(getApplicationContext(), ShapeGame.class);
            startActivity(intent);
        }
    }

    @Override
    public void addSoal(int val) {

    }

    @Override
    public void addScore(int val) {

    }

}
