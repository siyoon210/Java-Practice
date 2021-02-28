package com.fastcampus3.businesscard;

import lombok.*;

import java.util.List;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@ToString @EqualsAndHashCode
public class BusinessCardData {
    private int maxNum;
    private List<com.fastcampus3.businesscard.BusinessCard> businessCardList;
}
