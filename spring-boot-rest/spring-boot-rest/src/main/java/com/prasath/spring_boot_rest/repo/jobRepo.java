package com.prasath.spring_boot_rest.repo;
import com.prasath.spring_boot_rest.model.JobApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
@Repository
public interface jobRepo extends JpaRepository<JobApp,Integer> {

    List<JobApp> findByPostDescContainingOrPostProfile(String key, String key1);
}
