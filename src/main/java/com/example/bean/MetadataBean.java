package com.example.bean;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.lang.reflect.Field;

@Named
@RequestScoped
public class MetadataBean {

    @PostConstruct
    public void init() {
        try {
            Class<?> clazz = CalculationBean.class;
            Field[] fields = clazz.getDeclaredFields();

            for (Field field : fields) {
                System.out.println("Field: " + field.getName() + ", Type: " + field.getType());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}