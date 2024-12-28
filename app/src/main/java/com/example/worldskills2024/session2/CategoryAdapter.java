package com.example.worldskills2024.session2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.worldskills2024.R;

//Адаптер для списка категорий на главном фрагменте
//25.12.2024
//Саматова Анастасия
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ButtonViewHolder> {
    //Поля
    private String[] data;
    private View.OnClickListener onClickListener;

    //Конструктор
    public CategoryAdapter(String[] data) {
        this.data = data;
        this.onClickListener = onClickListener;
    }

    //Здесь создается кнопка
    @NonNull
    @Override
    public ButtonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item_shape, parent, false);
        return new ButtonViewHolder(view);
    }

    //Здесь пишем логику этой кнопки, наполняем данными
    @Override
    public void onBindViewHolder(@NonNull ButtonViewHolder holder, int position) {
        holder.button.setText(data[position]); //Здесь устанавливаем текст
        holder.button.setOnClickListener(onClickListener); //Устанавливаем слушатель нажатий

    }

    //Возвращает количество элементов (строк для кнопок)
    @Override
    public int getItemCount() {
        return data.length;
    }

    //ViewHolder, чтобы оптимизировать работу RecyclerView
    static class ButtonViewHolder extends RecyclerView.ViewHolder {
        Button button;

        public ButtonViewHolder (@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.categoryButton);
        }

    }
}

