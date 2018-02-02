package ru.shaldnikita.forms.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.shaldnikita.forms.backend.models.entity.Data;

import java.util.List;

public interface DataRepository extends JpaRepository<Data, String> {

    @Query("SELECT distinct d.ssoid ,d.formId FROM Data d where form_id <> ''")
    List<Object[]> getUsersAndForms();
    /*
     @Query("select d.ssoid, ")
    List<String[]> getUsersWithUnfinishedForms();*/

    @Query(value = "SELECT form_id FROM Data where form_id <> '' GROUP by form_id order by count(form_id) desc limit 5", nativeQuery = true)
    List<String> getTopFiveForms();
}
