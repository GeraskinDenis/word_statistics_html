package ru.geraskindenis.word_statistics_html.service.impl;

import ru.geraskindenis.word_statistics_html.model.StatisticsRecord;
import ru.geraskindenis.word_statistics_html.repository.StatisticsRecordRepository;
import ru.geraskindenis.word_statistics_html.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RecordServiceImpl implements RecordService {

    private final StatisticsRecordRepository repository;

    @Override
    public StatisticsRecord save(StatisticsRecord record) {
        return repository.save(record);
    }

    @Override
    public List<StatisticsRecord> getAll() {
        return repository.findAll();
    }
}
