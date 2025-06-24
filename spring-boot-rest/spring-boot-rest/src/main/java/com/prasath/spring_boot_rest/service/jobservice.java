package com.prasath.spring_boot_rest.service;


import com.prasath.spring_boot_rest.model.JobApp;
import com.prasath.spring_boot_rest.repo.jobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class jobservice {
    List<JobApp> j=new ArrayList<>(Arrays.asList(new JobApp(101,"java","i am here to done",2,new ArrayList<>(Arrays.asList("java","python"))),
            new JobApp(102,"javascript","i am here to done",2,new ArrayList<>(Arrays.asList("javascript","python"))),
            new JobApp(103,"java","i am here to done",2,new ArrayList<>(Arrays.asList("java","python")))));
    @Autowired
    private jobRepo repo;
    public void addjob(JobApp jo){
        repo.save(jo);
    }
    public List<JobApp> getAllJob(){
        return repo.findAll();
    }

    public JobApp viewJob(int pi) {
        return repo.findById(pi).orElse(new JobApp());
    }

    public void updateJob(JobApp jj) {
        repo.save(jj);
    }

    public void deleteJob(int jj) {
        repo.deleteById(jj);
    }
    public void load(){
        repo.saveAll(j);
    }

    public List<JobApp> keyword(String key) {
        return repo.findByPostDescContainingOrPostProfile(key,key);
    }
}
