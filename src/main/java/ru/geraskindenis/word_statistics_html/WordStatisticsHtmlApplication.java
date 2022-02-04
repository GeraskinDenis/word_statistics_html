package ru.geraskindenis.word_statistics_html;

<<<<<<< HEAD
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
=======
>>>>>>> parent of 25f3ec5 (Class WordStatisticsHtmlApplication)
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
<<<<<<< HEAD
@RequiredArgsConstructor
@Slf4j
=======
>>>>>>> parent of 25f3ec5 (Class WordStatisticsHtmlApplication)
public class WordStatisticsHtmlApplication {

    public static void main(String[] args) {
        SpringApplication.run(WordStatisticsHtmlApplication.class, args);
        log.info("Starting application with {} arguments.", args.length);
    }

<<<<<<< HEAD
    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        log.info("Before Starting Service");
        initService.run(url);
    }
=======
>>>>>>> parent of 25f3ec5 (Class WordStatisticsHtmlApplication)
}
