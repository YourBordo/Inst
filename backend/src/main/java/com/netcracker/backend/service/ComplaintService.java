package com.netcracker.backend.service;

import com.netcracker.backend.entity.Complaint;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ComplaintService {
    Complaint find(String name);
    List<Complaint> findAll();
    Complaint add(Complaint complaint );
    Complaint delete(Long id);
    List<Complaint> getPage(int page, int size);
}
