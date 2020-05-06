package com.netcracker.fapi.services;

import com.netcracker.fapi.entity.Complaint;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ComplaintService {
    Complaint find(String name);
    List<Complaint> findAll();
    Complaint add(Complaint complaint);
    Complaint delete(Long id);
    List<Complaint> getPage(int page, int size);
}
