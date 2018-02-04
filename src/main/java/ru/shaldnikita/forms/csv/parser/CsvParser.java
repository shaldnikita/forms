package ru.shaldnikita.forms.csv.parser;

import org.apache.commons.csv.CSVFormat;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.shaldnikita.forms.app.HasLogger;
import ru.shaldnikita.forms.backend.models.entity.Data;

import java.io.FileReader;
import java.io.Reader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
@Scope("prototype")
public class CsvParser implements HasLogger {

    public List<Data> parseCsv(String fileName) {

        CopyOnWriteArrayList<Data> result = new CopyOnWriteArrayList<>();

        try (Reader in = new FileReader(fileName)) {
            CSVFormat.EXCEL.withHeader().withDelimiter(';')
                    .parse(in)
                    .getRecords()
                    .parallelStream()
                    .forEach(record -> {
                        Data data = new Data();

                        data.setSsoid(record.get(0));
                        data.setTs(record.get(1));
                        data.setGrp(record.get(2));
                        data.setType(record.get(3));
                        data.setSubType(record.get(4));
                        data.setUrl(record.get(5));
                        data.setOrgId(record.get(6));
                        data.setFormId(record.get(7));
                        data.setCode(record.get(8));
                        data.setLtpa(record.get(9));
                        data.setSuDirResponse(record.get(10));
                        data.setYmdh(LocalDateTime.parse(record.get(11), DateTimeFormatter.ofPattern("yyyy-MM-dd-HH")));

                        result.add(data);
                    });
        } catch (Exception e) {
            getLogger().error("error while parsing file", e);
        }

        getLogger().debug("total size: {}", result.size());
        return result;
    }

}
