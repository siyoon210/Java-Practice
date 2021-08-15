package com.example.beancirculardependecytest.c;

import com.example.beancirculardependecytest.a.BeanA;
import org.springframework.stereotype.Component;

@Component
public class BeanC {
    private final BeanA beanA;

    public BeanC(BeanA beanA) {
        this.beanA = beanA;
    }
}
