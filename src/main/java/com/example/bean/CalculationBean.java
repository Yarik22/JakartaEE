package com.example.bean;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;

@Named
@RequestScoped
public class CalculationBean {

    private int initialValue;
    private int result;

    public CalculationBean() {
        // Початкове значення
        this.initialValue = 10;
        this.result = initialValue;
    }

    // Метод для додавання
    public void add(int value) {
        this.result += value;
    }

    // Метод для віднімання
    public void subtract(int value) {
        this.result -= value;
    }

    // Getter для результату
    public int getResult() {
        return result;
    }

    // @Produces для результату
    @Produces
    @Named("producedResult")
    public int getProducedResult() {
        return result;
    }

    // Getter та Setter для початкового значення
    public int getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(int initialValue) {
        this.initialValue = initialValue;
        this.result = initialValue; // оновлюємо результат, щоб синхронізувати
    }

    public String getClassName() {
        return this.getClass().getSimpleName();
    }

    public String getPackageName() {
        return this.getClass().getPackageName();
    }

}
