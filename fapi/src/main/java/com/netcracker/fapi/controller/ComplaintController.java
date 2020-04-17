package com.netcracker.fapi.controller;

import com.netcracker.fapi.entity.Complaint;
import com.netcracker.fapi.services.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/complaint")
public class ComplaintController {//

    @Autowired
    private ComplaintService complaintService;

    @RequestMapping(value = "/{txt}", method = RequestMethod.GET)
    public Complaint getComplaintByText(@PathVariable(name = "txt") String text) {
        return complaintService.find(text);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Complaint addComplaint(@RequestBody Complaint complaint) {
        return complaintService.add(complaint);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteComplaint(@PathVariable(name = "id") Long id) {
         complaintService.delete(id);
    }

}
