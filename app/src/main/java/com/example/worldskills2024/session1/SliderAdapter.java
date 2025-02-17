package com.example.worldskills2024.session1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.worldskills2024.R;
import com.example.worldskills2024.session4.LoginFragment;

import java.util.List;

//Саматова Анастасия
//19.01.2025
//Класс, который является адаптером для 3х слайдеров
public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.ViewHolder>{
    public List<Integer> sliders;
    public LayoutInflater inflater;
    public FragmentManager fragmentManager;

    public SliderAdapter (Context context, List<Integer> sliders, FragmentManager fragmentManager) {
        this.sliders = sliders;
        this.inflater = LayoutInflater.from(context);
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(viewType, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        switch (position) {
            case 0:
                //Находим кнопочку через холдер
                Button button = holder.itemView.findViewById(R.id.nextButton1);
                //Если кнопочка есть - делаем слушатель нажатий
                if (button != null) {
                    //Делаем метод, который получает через холдер ресайкл вью, а затем меняет позицию на следующий слайд
                    button.setOnClickListener(v ->
                    {
                        RecyclerView recyclerView = (RecyclerView) holder.itemView.getParent();
                        if (recyclerView != null) {
                            recyclerView.smoothScrollToPosition(position + 1);
                        }
                    });
                }
                break;
            case 1:
                //Находим кнопку
                Button button1 = holder.itemView.findViewById(R.id.nextButton2);
                //Если кнопка есть
                if (button1 != null) {
                    //Делаем метод, который получает ресайкл вью
                    button1.setOnClickListener(v -> {
                        RecyclerView recyclerView = (RecyclerView) holder.itemView.getParent();
                        //Если ресайкл вью есть
                        if (recyclerView != null) {
                            recyclerView.smoothScrollToPosition(position + 1);
                        }
                    });
                }
                break;
            case 2:
                //Находим кнопку
                Button button2 = holder.itemView.findViewById(R.id.nextButton3);
                //Если кнопка есть
                if (button2 != null) {
                    //Создаем слушатель нажатий
                    button2.setOnClickListener(v -> {
                        LoginFragment loginFragment = new LoginFragment();
                        FragmentTransaction ft = fragmentManager.beginTransaction();
                        ft.add(R.id.fragmentContainerLogin, loginFragment);
                        ft.addToBackStack(null);
                        ft.commit();
                    });
                }
                break;

        }

    }

    @Override
    public int getItemViewType(int position) {
        return sliders.get(position);
    }

    @Override
    public int getItemCount() {
        return sliders.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
