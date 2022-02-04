package ru.geraskindenis.word_statistics_html.service.impl;

import ru.geraskindenis.word_statistics_html.service.InitService;
import ru.geraskindenis.word_statistics_html.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geraskindenis.word_statistics_html.model.StatisticsRecord;
import ru.geraskindenis.word_statistics_html.util.HtmlParser;
import ru.geraskindenis.word_statistics_html.util.UtilStatistics;

@RequiredArgsConstructor
@Service
public class InitServiceImpl implements InitService {

    private final RecordService recordService;

    @Override
    public void run(String url) {
        var text = HtmlParser.getText(url);
        if (text == null) {
            return;
        }
        var regex = "[,\"«»()©'\\[\\]:%]|\\s-\\s|\\.(?=\\s)|\\d{2}\\.\\d{2}\\.\\d{4}|(?<=\\s)\\d+(?=\\s)|\\d-\\d{3}-\\d{3}-\\d{4}|\\.$|—";
        text = text.replaceAll(regex, "");
        UtilStatistics.getNumberOfRepetitions(text)
                .forEach((word, count) -> {
                    var record = new StatisticsRecord()
                            .setQuantity(count)
                            .setUrl(url)
                            .setWord(word);
                    recordService.save(record);
                });

    }
}
