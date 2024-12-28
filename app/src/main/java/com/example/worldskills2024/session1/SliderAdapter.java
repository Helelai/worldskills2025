package com.example.worldskills2024.session1;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.worldskills2024.R;
import com.example.worldskills2024.session2.GeneralActivity;

//Саматова Анастасия
//21.12.2024
//Адаптер для слайдера начальных экранов
public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderViewHolder> { // что-то наследует

    //Массив слоев
    private int[] layouts;
    //Наш ViewPager2, который будет все делать
    private ViewPager2 viewPager2;


    //Создаем конструкторы
    public SliderAdapter (int[] layouts, ViewPager2 viewPager2) {
        this.layouts = layouts;
        this.viewPager2 = viewPager2;
    }

    //Делаем onCreateViewHolder
    @NonNull
    @Override
    public SliderAdapter.SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Раздуваем нужное нам view
        View view = LayoutInflater.from(parent.getContext()).inflate(layouts[viewType],parent, false);

        //Создаем ViewHolder передавая представление
        return new SliderViewHolder(view);
    }

    //Делаем onBindViewHolder - логика нашего адаптера
    @Override
    public void onBindViewHolder(@NonNull SliderAdapter.SliderViewHolder holder, int position) {
        //Если слайд 1 (0)
        if (position == 0) {
            //то берем его кнопочку
            Button nextButton = holder.itemView.findViewById(R.id.nextButton);
            //И делаем событие переключения на следующий слайд
            nextButton.setOnClickListener(v -> viewPager2.setCurrentItem(position + 1, true));
        }
        else if (position == 1) {
            Button nextButton = holder.itemView.findViewById(R.id.nextButton);
            nextButton.setOnClickListener(v -> viewPager2.setCurrentItem(position + 1, true));
        }
    }

    @Override
    public int getItemCount() {
        return layouts.length;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public static class SliderViewHolder extends  RecyclerView.ViewHolder {
        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
