package com.example.bean;

import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@SessionScoped
public class CalculationBean implements Serializable {


    // Поле для початкового значення
    private int initialValue = 10;

    // Поточне значення для операцій
    private int currentValue;

    // Конструктор
    public CalculationBean() {
        this.currentValue = initialValue;
    }

    // @Produces для надання початкового значення
    @Produces
    @Named("initialValue")
    public int produceInitialValue() {
        return initialValue;
    }

    // Методи для додавання і віднімання
    public void add(int value) {
        currentValue += value;
    }

    public void subtract(int value) {
        currentValue -= value;
    }

    // Геттери та сеттери
    public int getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }

    public int getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(int initialValue) {
        this.initialValue = initialValue;
    }
}