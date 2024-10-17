package com.example.controllers;

import com.example.bean.CalculationBean;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@SessionScoped
public class CalculationController implements Serializable {

    @Inject
    private CalculationBean calculationBean;

    // Змінні для збереження введених значень
    private int valueToAdd;
    private int valueToSubtract;

    // Методи для додавання і віднімання введених значень
    public void add() {
        calculationBean.add(valueToAdd);
    }

    public void subtract() {
        calculationBean.subtract(valueToSubtract);
    }

    public int getCurrentValue() {
        return calculationBean.getCurrentValue();
    }

    public void setCurrentValue(int value) {
        calculationBean.setCurrentValue(value);
    }

    public int getInitialValue() {
        return calculationBean.getInitialValue();
    }

    public String getBeanMetadata() {
        return "Bean class: " + calculationBean.getClass().getSimpleName() +
                ", initial value: " + calculationBean.getInitialValue();
    }

    // Геттери та сеттери для введених значень
    public int getValueToAdd() {
        return valueToAdd;
    }

    public void setValueToAdd(int valueToAdd) {
        this.valueToAdd = valueToAdd;
    }

    public int getValueToSubtract() {
        return valueToSubtract;
    }

    public void setValueToSubtract(int valueToSubtract) {
        this.valueToSubtract = valueToSubtract;
    }
}