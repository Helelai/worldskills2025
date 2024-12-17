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

public class Onboard3Activity extends AppCompatActivity {
    float x1, x2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_onboard3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Свайпы
        //Берем наш активити
        View thisView = findViewById(android.R.id.content);
        thisView.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: //Начало касания
                    x1 = event.getX();
                    break;
                case MotionEvent.ACTION_UP:
                    x2 = event.getX();
                    float deltaX = x2 - x1; //Находим разницу

                    if (Math.abs(deltaX) > 150) {//Если больше минимальной длины свайпа
                        if (deltaX > 0) { //свайп вправо
                            Intent intent = new Intent(this, Onboard2Activity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
            }
            return true;
        });

    }

    public void SwitchB2Click(View view) {
        Intent intent = new Intent(this, Onboard2Activity.class);
        startActivity(intent);
        finish();
    }

    public void SwitchB1Click(View view) {
        Intent intent = new Intent(this, Onboard1Activity.class);
        startActivity(intent);
        finish();
    }

    //Свайпы
}