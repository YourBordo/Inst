package com.netcracker.backend.service.impl;
import com.netcracker.backend.entity. Complaint;
import com.netcracker.backend.repository.ComplaintPaginationRepository;
import com.netcracker.backend.repository. ComplaintRepository;
import com.netcracker.backend.service. ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class  ComplaintServiceImpl implements ComplaintService {
    @Autowired
    private  ComplaintRepository complaintRepository;
    @Autowired
    private ComplaintPaginationRepository complaintPaginationRepository;
    @Override
    public  Complaint find(String name) {
        return  complaintRepository.findByText(name);
    }

    @Override
    public  Complaint add( Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    @Override
    public  Complaint delete(Long id) {
        complaintRepository.deleteById(id);
        return null;
    }

    @Override
    public List<Complaint> findAll() {
        return complaintRepository.findAll();
    }

    @Override
    public List<Complaint> getPage(int page, int size) {

        return complaintPaginationRepository.findAll(PageRequest.of(page, size)).getContent();
    }
}
