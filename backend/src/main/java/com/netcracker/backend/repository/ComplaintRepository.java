package com.netcracker.backend.repository;

import com.netcracker.backend.entity.Complaint;
import com.netcracker.backend.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ComplaintRepository extends /*CrudRepository<Complaint, Long>,*/ PagingAndSortingRepository<Complaint, Long> {

    Complaint findByText(String text);
    List<Complaint> findAll();

    Page<Complaint> findAll(Pageable pageable);
}
