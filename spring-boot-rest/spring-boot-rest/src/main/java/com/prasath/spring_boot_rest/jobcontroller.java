package com.prasath.spring_boot_rest;

import com.prasath.spring_boot_rest.model.JobApp;
import com.prasath.spring_boot_rest.service.jobservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3001")
public class jobcontroller {
    @Autowired
    private jobservice service;
    @GetMapping("jobposts")
    public List<JobApp> viewAllJob(){
        return service.getAllJob();
    }
    @GetMapping("jobpost/{pi}")
    public JobApp viewJob(@PathVariable("pi") int p){
        return service.viewJob(p);
    }
    @PostMapping("jobpost")
    public void addjob(@RequestBody JobApp jj){
        service.addjob(jj);
    }
    @PutMapping("jobpost")
    public JobApp updateJob(@RequestBody JobApp jj){
        service.updateJob(jj);
        return service.viewJob(jj.getPostId());
    }
    @DeleteMapping("jobpost/{pi}")
    public List<JobApp> deleteJob(@PathVariable("pi") int jj){
        service.deleteJob(jj);
        return service.getAllJob();
    }
    @GetMapping("jobpost/keyword/{key}")
    public List<JobApp> keyword(@PathVariable("key") String key){
        return service.keyword(key);
    }
    @GetMapping("load")
    public String load(){
        service.load();
        return "success";
    }
}
