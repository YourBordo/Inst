package com.netcracker.fapi.services.impl;

import com.netcracker.fapi.entity. Complaint;
import com.netcracker.fapi.services. ComplaintService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component/*сервис, реализующий запрос на бэкенд*/
public class ComplaintServiceImpl implements ComplaintService {

    @Value("${backend.server.url}")
    private String BackendUrl;

    @Override
    public Complaint find(String text) {
        RestTemplate restTemplate = new RestTemplate();
        Complaint complaint = restTemplate.getForObject(BackendUrl + "/api/complaint/" + text, Complaint.class);
        return complaint;
    }

    @Override
    public Complaint add(Complaint complaint) {
        RestTemplate restTemplate = new RestTemplate();
        Complaint complaint1 = restTemplate.postForObject(BackendUrl + "/api/complaint/",complaint, Complaint.class);
        return complaint1;
    }

    @Override
    public void delete(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(BackendUrl + "/api/complaint/" + id); }
}
