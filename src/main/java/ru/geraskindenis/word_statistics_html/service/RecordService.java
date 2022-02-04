package ru.geraskindenis.word_statistics_html.service;

import ru.geraskindenis.word_statistics_html.model.StatisticsRecord;

import java.util.List;

public interface RecordService {
    StatisticsRecord save(StatisticsRecord record);

    List<StatisticsRecord> getAll();
}
