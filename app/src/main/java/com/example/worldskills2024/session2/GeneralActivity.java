package com.example.worldskills2024.session2;

import static com.example.worldskills2024.R.*;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.worldskills2024.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class  GeneralActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_general);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Fragment startFragment = new HomeFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(id.fragmentContainer, startFragment);
        ft.commit();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        //Устанавливаем слушатель нажатия на элемент
        bottomNavigationView.setOnItemSelectedListener(item -> {
            //Переменная для выбранного фрагмента
            Fragment selectedFragment = null;

            //Проверяем, какой элемент меню нажал пользователь
            if (item.getItemId() == id.nav_home) {
                selectedFragment = new HomeFragment();
            }
            else if (item.getItemId() == id.nav_heart) {
                selectedFragment = new FavoritesFragment();
            }

            //Если есть элемент
            if (selectedFragment != null) {
                //То вызываем FragmentTransaction и начинаем транзакцию
                FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();

                //Заменяем элемент на наш фрагмент
                ft2.replace(id.fragmentContainer, selectedFragment);

                // Завершаем транзакцию
                ft2.commit();
            }

            return true;
        });
    }
}