package com.netcracker.backend.repository;

import com.netcracker.backend.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
/*
определяeт бины Spring
@Repository — компонент, который предназначен для хранения, извлечения и поиска.
 Как правило, используется для работы с базами данных.
*/
@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findAll();

/*
    Student findByName(String name);
*/

}
