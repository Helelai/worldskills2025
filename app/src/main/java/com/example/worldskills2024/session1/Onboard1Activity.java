package com.example.worldskills2024.session1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.example.worldskills2024.R;
import com.example.worldskills2024.session2.GeneralActivity;

public class Onboard1Activity extends AppCompatActivity {
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        //Флаг, чтобы пользователь видел onboard единожды
        preferences = getSharedPreferences("onboarding", MODE_PRIVATE);
        boolean isOnboardingCompleted = preferences.getBoolean("isCompleted", false);

        if (isOnboardingCompleted) {
            Intent intent = new Intent(this, GeneralActivity.class);
            startActivity(intent);
            finish();
        }
        else {
            setContentView(R.layout.activity_onboard1);
            setupViewPager();
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }

    }
    private void setupViewPager() {
        //Создаем ViewPager
        ViewPager2 viewPager = findViewById(R.id.viewpager2);

        // Передаём массив макетов
        int[] layouts = {R.layout.slide1, R.layout.slide2, R.layout.slide3};

        //Создаем адаптер
        SliderAdapter sliderAdapter = new SliderAdapter(layouts, viewPager);

        viewPager.setAdapter(sliderAdapter);
    }
    public void gotoGeneral(View view) {

        //Изменяем флаг
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isCompleted", true);
        editor.apply();

        Intent intent = new Intent(this, GeneralActivity.class);
        startActivity(intent);
        finish();
    }
}

