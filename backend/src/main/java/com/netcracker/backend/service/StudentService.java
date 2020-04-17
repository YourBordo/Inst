package com.netcracker.backend.service;

import com.netcracker.backend.entity.Student;
import org.springframework.stereotype.Component;

/*
@Component — универсальный компонент
@Service — фасад для некоторой бизнес логики
*/
@Component
public interface StudentService {
    Iterable<Student> find();
/*//
    Student find(String name);
*/

}
