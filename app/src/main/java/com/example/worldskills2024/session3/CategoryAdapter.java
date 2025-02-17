package com.example.worldskills2024.session3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.worldskills2024.R;

import java.util.ArrayList;
import java.util.List;

//Саматова Анастасия
//14.01.2025
//Класс-адаптер, необходимый для связи данных и разметки
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    //Поля
    public LayoutInflater inflater;
    public List<Category> categories;

    //Конструктор
    public CategoryAdapter(Context context, List<Category> categories) {
        this.categories = categories;
        this.inflater = LayoutInflater.from(context);
    }

    public CategoryAdapter(HomeFragment homeFragment, ArrayList<Category> categories) {
    }

    //Инициализация разметки
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.category_item_layout, parent, false);
        return new ViewHolder(view);
    }

    //Логика, связь с данными
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category category = categories.get(position);
        holder.categoryButton.setText(category.getCategoryName());
    }

    //Метод, возвращающий количество элементов
    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        Button categoryButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            categoryButton = itemView.findViewById(R.id.categoryButton);
        }
    } {

    }


}
