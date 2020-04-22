package com.netcracker.backend.repository;

import com.netcracker.backend.entity.Complaint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintPaginationRepository extends  PagingAndSortingRepository<Complaint, Long> {

    Page<Complaint> findAll(Pageable pageable);
}
