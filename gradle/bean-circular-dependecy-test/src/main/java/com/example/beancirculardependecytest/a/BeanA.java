package com.example.beancirculardependecytest.a;

import com.example.beancirculardependecytest.b.BeanB;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BeanA {
    private final BeanB beanB;
}
