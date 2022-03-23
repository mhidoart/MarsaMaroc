package com.example.marsamaroc.repo;

import com.example.marsamaroc.model.Grue;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GrueRepo extends CrudRepository<Grue,Long> {
    List<Grue> findAll();

}
