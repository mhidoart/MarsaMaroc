package com.example.marsamaroc;

import com.example.marsamaroc.model.Grue;
import com.example.marsamaroc.repo.GrueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarsaMarocApplication implements ApplicationRunner {

    @Autowired
    private GrueRepo grue_repo;
    public static void main(String[] args) {
        SpringApplication.run(MarsaMarocApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        grue_repo.save(new Grue(new Long(100),"MarsaNavy"));
        grue_repo.save(new Grue(new Long(251),"La Blanca"));
        grue_repo.save(new Grue(new Long(333),"Estamos"));
        grue_repo.save(new Grue(new Long(120),"Big Oly"));
        grue_repo.save(new Grue(new Long(521),"Hassan 2"));
        grue_repo.save(new Grue(new Long(953),"Pescada"));
    }
}
