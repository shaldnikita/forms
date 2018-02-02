package ru.shaldnikita.forms.csv;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shaldnikita.forms.app.HasLogger;
import ru.shaldnikita.forms.backend.models.entity.Data;
import ru.shaldnikita.forms.backend.repository.DataRepository;
import ru.shaldnikita.forms.csv.parser.CsvParser;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class CsvFileHandler implements HasLogger {

    private final String fileName = "test_case.csv";


    @Autowired
    private CsvParser parser;

    @Autowired
    private DataRepository dataRepository;

    @PostConstruct
    private void init(){

        List<Data> dataList = parser.parseCsv(fileName);

        //todo remove
        if(dataList.isEmpty())
             return;

        //todo maybe use parallelStream()
        dataList.stream().forEach(data ->{
            dataRepository.save(data);
        });
    }
}
