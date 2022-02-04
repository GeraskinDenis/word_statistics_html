package ru.geraskindenis.word_statistics_html.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geraskindenis.word_statistics_html.model.StatisticsRecord;

public interface StatisticsRecordRepository extends JpaRepository<StatisticsRecord, Long> {
}