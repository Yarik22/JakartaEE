package com.example.controllers;


import com.example.bean.CalculationBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class CalculationController {

    @Inject
    private CalculationBean calculationBean;

    // Властивість для додавання
    private int addValue;

    // Властивість для віднімання
    private int subtractValue;

    // Геттер та сетер для додавання
    public int getAddValue() {
        return addValue;
    }

    public void setAddValue(int addValue) {
        this.addValue = addValue;
    }

    // Геттер та сетер для віднімання
    public int getSubtractValue() {
        return subtractValue;
    }

    public void setSubtractValue(int subtractValue) {
        this.subtractValue = subtractValue;
    }

    // Метод для додавання значення
    public void performAdd() {
        calculationBean.add(addValue);
    }

    // Метод для віднімання значення
    public void performSubtract() {
        calculationBean.subtract(subtractValue);
    }

    public int getResult() {
        return calculationBean.getResult();
    }
}