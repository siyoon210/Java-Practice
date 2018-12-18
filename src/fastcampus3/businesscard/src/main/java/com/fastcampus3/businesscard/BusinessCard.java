package com.fastcampus3.businesscard;

import lombok.*;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@Setter
@Getter
public class BusinessCard {
    private int id;
    private String name;
    private String phone;
    private String companyName;
}
