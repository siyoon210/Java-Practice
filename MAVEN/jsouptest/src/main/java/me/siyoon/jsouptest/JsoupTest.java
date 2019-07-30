package me.siyoon.jsouptest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * https://offbyone.tistory.com/116
 */
public class JsoupTest {
    public static void main(String[] args) throws IOException {
        final Document document = Jsoup.connect("https://www.wirebarley.com").get();
        System.out.println("document.title() = " + document.title());
        System.out.println("document.body() = " + document.body());
    }
}
