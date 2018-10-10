package com.didgustn319.my_memo_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.didgustn319.my_memo_app.database.MemoVO;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class SplashActivity extends AppCompatActivity {


    List<String> pageTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // 처음 App 이 실행되면서 Main 화면이 나올때까지 딜레이 되는
        // 코드들 작성


        // 스플레시를 강제로 2초간 보여주기
        // SpashActivity에 theme가 설정되 있을때만 효과 나타난다.
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//            Log.d("Thread","sleep");
//        }


        final long curTime = System.currentTimeMillis();
        pageTitles = new ArrayList<>();

        FirebaseDatabase.getInstance().getReference("my_memo")
//                .addValueEventListener(null)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        pageTitles.clear();

                        Log.d("DATASNAPSHOT", dataSnapshot.toString());
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            MemoVO vo = ds.getValue(MemoVO.class);
                            Log.d("createView", vo.toString());
                            pageTitles.add(vo.getMemoCat());
                            Log.d("GET-DATA", dataSnapshot.toString());
                        }

                        // 중복코드 제거
                        pageTitles = new ArrayList<>(new TreeSet<>(pageTitles));

                        // 딜레이 코드가 완료되면 MainActivity를 띄우고
                        // 자신(Splash) 종료


                        long lastTime = System.currentTimeMillis();

                        // 딜레
                        try {
                            Thread.sleep(lastTime - curTime - 4000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            Log.d("Thread", "sleep");
                        }

                        Intent mainAc = new Intent(SplashActivity.this, MainActivity.class);
                        mainAc.putStringArrayListExtra("PAGE_TITLE", (ArrayList<String>) pageTitles);
                        startActivity(mainAc);
                        finish();


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Log.d("F-ERROR", databaseError.toString());
                    }
                });


    }
}