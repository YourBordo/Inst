package com.netcracker.backend.controller;

import com.netcracker.backend.entity.Complaint;
import com.netcracker.backend.entity.Student;
import com.netcracker.backend.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.util.*;
import java.util.List;

@RestController
@RequestMapping("/api/complaint")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @RequestMapping(value = "/{txt}", method = RequestMethod.GET)
    public Complaint getComplaintByText(@PathVariable(name = "txt") String text) {
        return complaintService.find(text);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Complaint> getComplaints() {
        return complaintService.findAll();
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Complaint addComplaint(@RequestBody Complaint complaint) {
        return complaintService.add(complaint);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Complaint deleteComplaint(@PathVariable(name = "id") Long id) {
        return complaintService.delete(id);
    }

    @RequestMapping(value = "/{page}/{size}", method = RequestMethod.GET)
    public List<Complaint> getComplaintsPage(@PathVariable(name = "page") int page, @PathVariable(name = "size") int size) {
        return complaintService.getPage(page, size);
    }

}
