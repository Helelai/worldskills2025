package com.example.worldskills2024;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Onboard2Activity extends AppCompatActivity {
    private float x1, x2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_onboard2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Свайпы
        //Берем наш View
        View thisView = findViewById(android.R.id.content);
        thisView.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: //Начало касания
                    x1 = event.getX();
                    break;

                case MotionEvent.ACTION_UP: //Конец касания
                    x2 = event.getX();
                    float deltaX = x2 - x1; //Находим разницу

                    //Определяем направление касания
                    if (Math.abs(deltaX) > 150) //минимальная длина свайпа
                        if (deltaX < 0 ) { // свайп влево
                            Intent intent2 = new Intent(this, Onboard3Activity.class);
                            startActivity(intent2);
                            finish();
                        }
                        else if (deltaX > 0) { //свайп вправо
                            Intent intent = new Intent(this, Onboard1Activity.class);
                            startActivity(intent);
                            finish();
                        }
                        else {

                        }
                        break;
            }
            return true;
        });

    }

    public void SwitchB1Click(View view) {
        Intent intent = new Intent(this, Onboard1Activity.class);
        startActivity(intent);
        finish();
    }

    public void SwitchB3Click(View view) {
        Intent intent = new Intent(this, Onboard3Activity.class);
        startActivity(intent);
        finish();
    }

    public void NextBClick(View view) {
        Intent intent = new Intent(this, Onboard3Activity.class);
        startActivity(intent);
        finish();
    }




}