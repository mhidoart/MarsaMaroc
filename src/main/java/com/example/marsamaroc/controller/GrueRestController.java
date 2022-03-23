package com.example.marsamaroc.controller;

import com.example.marsamaroc.exception.GrueNotFoundException;
import com.example.marsamaroc.model.Grue;
import com.example.marsamaroc.repo.GrueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grue")

public class GrueRestController {
    @Autowired
    private GrueRepo grueRepo;

    @GetMapping("/")
    public List<Grue> getAll(){
        return  grueRepo.findAll();
    }

    @PostMapping("/")
    Grue newGrue(@RequestBody Grue newGrue) {
        return grueRepo.save(newGrue);
    }

    @GetMapping("/{id}")
    Grue one(@PathVariable Long id) {

        return grueRepo.findById(id)
                .orElseThrow(() -> new GrueNotFoundException(id));
    }

    @PutMapping("/{id}")
    Grue replaceGrue(@RequestBody Grue newGrue, @PathVariable Long id) {

        return grueRepo.findById(id)
                .map(grue -> {
                    grue.setNom(grue.getNom());
                    return grueRepo.save(grue);
                })
                .orElseGet(() -> {
                    newGrue.setId(id);
                    return grueRepo.save(newGrue);
                });
    }

    @DeleteMapping("/{id}")
    void deleteGrue(@PathVariable Long id) {
        grueRepo.deleteById(id);
    }


    /*

      @GetMapping("/employees")
  List<Employee> all() {
    return repository.findAll();
  }
  // end::get-aggregate-root[]

  @PostMapping("/employees")
  Employee newEmployee(@RequestBody Employee newEmployee) {
    return repository.save(newEmployee);
  }

  // Single item

  @GetMapping("/employees/{id}")
  Employee one(@PathVariable Long id) {

    return repository.findById(id)
      .orElseThrow(() -> new EmployeeNotFoundException(id));
  }

  @PutMapping("/employees/{id}")
  Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

    return repository.findById(id)
      .map(employee -> {
        employee.setName(newEmployee.getName());
        employee.setRole(newEmployee.getRole());
        return repository.save(employee);
      })
      .orElseGet(() -> {
        newEmployee.setId(id);
        return repository.save(newEmployee);
      });
  }

  @DeleteMapping("/employees/{id}")
  void deleteEmployee(@PathVariable Long id) {
    repository.deleteById(id);
  }
}
     */
}
