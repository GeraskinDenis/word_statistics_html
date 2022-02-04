package ru.geraskindenis.word_statistics_html;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import ru.geraskindenis.word_statistics_html.service.InitService;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class WordStatisticsHtmlApplication {

    private static String url = "";

    private final InitService initService;

    public static void main(String[] args) {
        url = args.length == 0 ? "https://www.simbirsoft.com/": args[0];
        SpringApplication.run(WordStatisticsHtmlApplication.class, args);
        log.info("Starting application with {} arguments.", args.length);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        log.info("Before Starting Service");
        initService.run(url);
    }
}
