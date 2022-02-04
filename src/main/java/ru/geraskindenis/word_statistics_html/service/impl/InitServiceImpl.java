package ru.geraskindenis.word_statistics_html.service.impl;

import lombok.extern.slf4j.Slf4j;
import ru.geraskindenis.word_statistics_html.service.InitService;
import ru.geraskindenis.word_statistics_html.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geraskindenis.word_statistics_html.model.StatisticsRecord;
import ru.geraskindenis.word_statistics_html.util.HtmlParser;
import ru.geraskindenis.word_statistics_html.util.UtilStatistics;

@RequiredArgsConstructor
@Service
@Slf4j
public class InitServiceImpl implements InitService {

    private final RecordService recordService;

    @Override
    public void run(String url) {
        log.info("Getting text from a HTML-page: " + url);
        var text = HtmlParser.getText(url);
        if (text == null) {
            return;
        }
        log.info("Text received successfully!");

        var regex = "[,\"«»()©'\\[\\]:%]|\\s-\\s|\\.(?=\\s)|\\d{2}\\.\\d{2}\\.\\d{4}|(?<=\\s)\\d+(?=\\s)|\\d-\\d{3}-\\d{3}-\\d{4}|\\.$|—";
        text = text.replaceAll(regex, "");

        log.info("Getting statistics of word and write to database...");
        StringBuilder builder = new StringBuilder("===Start of report===\n");
        UtilStatistics.getNumberOfRepetitions(text)
                .forEach((word, count) -> {
                    var record = new StatisticsRecord()
                            .setQuantity(count)
                            .setUrl(url)
                            .setWord(word);
                    recordService.save(record);

                    builder.append(record.getUrl())
                            .append(" - ")
                            .append(record.getWord())
                            .append(" - ")
                            .append(record.getQuantity())
                            .append("\n");
                });
        log.info("Statistics successfully received and written to the database!");
        log.info(builder.toString());
    }
}
