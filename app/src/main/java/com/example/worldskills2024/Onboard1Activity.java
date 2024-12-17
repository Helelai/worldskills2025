package com.example.worldskills2024;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.worldskills2024.session2.GeneralActivity;

public class Onboard1Activity extends AppCompatActivity {
    private float x1, x2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_onboard1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Берем текущий View
        View thisView = findViewById(android.R.id.content);

        //Создаем слушатель касания
        thisView.setOnTouchListener((v, event) -> {
            //При помощи свитч-кейс определяем начало и конец касания
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: //Начало касания
                    x1 = event.getX();
                    break;
                case MotionEvent.ACTION_UP: //Конец касания
                    x2 = event.getX();
                    float deltaX = x2 - x1; //Вычисляем разницу?

                    //Определяем, было это касание влево или в право
                    if (Math.abs(deltaX) > 150) { //Минимальная длина свайпа
                        if (deltaX < 0) { //Это свайп влево
                            //Меняем активити
                            Intent intent = new Intent(this, Onboard2Activity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                    break;
            }
            return  true;
        });
    }

    public void SwitchB2Click(View view) {
        Intent intent = new Intent(this, Onboard2Activity.class);
        startActivity(intent);
    }

    public void SwitchB3Click(View view) {
        Intent intent = new Intent(this, Onboard3Activity.class);
        startActivity(intent);
    }

    public void gotoGeneral(View view) {
        Intent intent = new Intent(this, GeneralActivity.class);
        startActivity(intent);
    }
}