package ru.shaldnikita.forms.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.shaldnikita.forms.backend.entity.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface DataRepository extends JpaRepository<Data, String> {

    @Query("SELECT d.ssoid ,d.formId FROM Data d where d.ymdh between ?1 and ?2")
    List<String[]> getUsersAndForms(LocalDateTime first,LocalDateTime second);

     //@Query("select d.ssoid, ")
    //List<String[]> getUsersWithUnfinishedForms();

    @Query(value = "SELECT form_id FROM Data where form_id <> '' GROUP by form_id order by count(form_id) desc limit 5", nativeQuery = true)
    List<String> getTopFiveForms();
}
