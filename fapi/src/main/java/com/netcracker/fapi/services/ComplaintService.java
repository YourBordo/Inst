package com.netcracker.fapi.services;

import com.netcracker.fapi.entity.Complaint;
import org.springframework.stereotype.Component;

@Component
public interface ComplaintService {
    Complaint find(String text);
    Complaint add(Complaint complaint );
    void delete(Long id);

}
