package com.skripsi.saidi.gamematematika;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.skripsi.saidi.gamematematika.controller.GameController;
import com.skripsi.saidi.gamematematika.games.ForceGame;
import com.skripsi.saidi.gamematematika.games.OperationGame;
import com.skripsi.saidi.gamematematika.games.ShapeGame;

import java.util.Random;

public class GameAnchor extends AppCompatActivity {

    Random rand = new Random();
//    int n = rand.nextInt(3);
    int n = rand.nextInt(3);

    private DatabaseReference dbRef;
    private FirebaseDatabase database;


    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.game_anchor);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();


        String UID = currentUser.getUid();

        database = FirebaseDatabase.getInstance();
        dbRef = database.getReference("Users/"+UID+"/score/");


        int currentSoal = GameController.soal;

            // Berhenti ketika 20 soal
            if(currentSoal >= 20){
                // TODO Firebase score upload

            }
        if(n == 0 && currentSoal < 20){
           // do operation bilangan
            Intent intent = new Intent(getApplicationContext(), OperationGame.class);
            startActivity(intent);
        } else if(n == 1 && currentSoal < 20){
            // do pangkat
            Intent intent = new Intent(getApplicationContext(), ForceGame.class);
            startActivity(intent);
        } else if( n == 2 && currentSoal < 20){
            // do Bangun datar
            Intent intent = new Intent(getApplicationContext(), ShapeGame.class);
            startActivity(intent);
        } else if( currentSoal >= 20){
            String score = String.valueOf(GameController.score);
            dbRef.setValue(score);

            Intent intent = new Intent(getApplicationContext(), GamePreStart.class);
            startActivity(intent);

        }
        finish();



//        QUI.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                String value = dataSnapshot.getValue(String.class);
//                quiDisplay.setText(value);
//                Log.d("GAME ANCHOR", "QUI anda = "+value);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
    }
}
