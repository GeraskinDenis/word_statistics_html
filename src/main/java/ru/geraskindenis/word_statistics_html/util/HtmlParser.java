package ru.geraskindenis.word_statistics_html.util;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;

import java.io.IOException;

@Slf4j
public class HtmlParser {
    public static String getText(String url) {
        String document = null;
        try {
            document = Jsoup.connect(url).get().text();
        } catch (IOException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return document;
    }
}
