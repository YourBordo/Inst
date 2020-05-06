package com.netcracker.fapi.services.impl;

import com.netcracker.fapi.entity.Complaint;
import com.netcracker.fapi.services.ComplaintService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


@Component/*сервис, реализующий запрос на бэкенд*/
public class ComplaintServiceImpl implements ComplaintService {

    @Value("${backend.server.url}")
    private String BackendUrl;


    @Override
    public Complaint find(String name) {
        RestTemplate restTemplate = new RestTemplate();
        Complaint complaint = restTemplate.getForObject(BackendUrl + "/api/complaint/" + name, Complaint.class);
        return complaint;
    }

    @Override
    public List<Complaint> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        Complaint[] complaints = restTemplate.getForObject(BackendUrl + "/api/complaint/", Complaint[].class);
        return Arrays.asList(complaints);
    }

    @Override
    public Complaint add(Complaint complaint) {
        RestTemplate restTemplate = new RestTemplate();
        Complaint complaint1 = restTemplate.postForObject(BackendUrl +
                "/api/complaint/",complaint, Complaint.class);
        return complaint1;
    }

    @Override
    public Complaint delete(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(BackendUrl + "/api/complaint/" + id);
        return null;
    }

    @Override
    public List<Complaint> getPage(int page, int size) {
        RestTemplate restTemplate = new RestTemplate();
        Complaint[] complaints = restTemplate.getForObject(BackendUrl +
                "/api/complaint/page="+page+"/items="+size, Complaint[].class);
        return Arrays.asList(complaints);
    }
}
