package com.example.beancirculardependecytest.b;

import com.example.beancirculardependecytest.c.BeanC;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BeanB {
    private final BeanC beanC;
}
