package ru.shaldnikita.forms.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.shaldnikita.forms.backend.models.entity.Data;

import java.util.List;

public interface DataRepository extends JpaRepository<Data, String> {

    @Query("SELECT distinct d.ssoid ,d.formId FROM Data d where d.formId <> '' and d.ssoid<>'' ")
    List<Object[]> getUsersAndForms();

    @Query("SELECT  d.ssoid ,d.subType FROM Data d where d.grp like 'dszn_%' and d.formId <> '' and ssoid<>'' and sub_type <> 'send' ")
    List<Object[]> getUsersWithUnfinishedForms();

    @Query(value = "SELECT form_id FROM Data where form_id <> '' and ssoid <> '' GROUP by form_id order by count(form_id) desc limit 5", nativeQuery = true)
    List<String> getTopFiveForms();
}
