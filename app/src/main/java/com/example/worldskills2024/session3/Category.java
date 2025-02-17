package com.example.worldskills2024.session3;

//Саматова Анастасия
//14.01.2025
//Класс категории, необходимый для создания списка категорий
public class Category {
    //Поля класса
    private String categoryName;

    //Конструктор
    public Category (String categoryName) {
        this.categoryName = categoryName;
    }

    //Геттер
    public String getCategoryName() {
        return categoryName;
    }

    //Сеттер
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
