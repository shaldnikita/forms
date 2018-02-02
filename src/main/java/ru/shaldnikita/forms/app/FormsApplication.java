package ru.shaldnikita.forms.app;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.shaldnikita.forms.backend.models.entity.Data;
import ru.shaldnikita.forms.backend.repository.DataRepository;
import ru.shaldnikita.forms.csv.CsvFileHandler;
import ru.shaldnikita.forms.web.controller.ReportController;

@SpringBootApplication(scanBasePackageClasses = {FormsApplication.class, CsvFileHandler.class, ReportController.class})
@EnableJpaRepositories(basePackageClasses = {DataRepository.class})
@EntityScan(basePackageClasses = {Data.class})
public class FormsApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(FormsApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {

    }
}
