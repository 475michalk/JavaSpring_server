package com.example.javaspring.Controller;

import com.example.javaspring.Model.Branches;
import com.example.javaspring.Model.Customer;
import com.example.javaspring.Service.BranchesService;
import com.example.javaspring.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/branches")
public class BranchesController {
    @Autowired
    private BranchesService branchesService;

    @GetMapping
    public ArrayList<Branches> getAllBranches() {
        return this.branchesService.getBranches();
    }
    @PostMapping
    public Branches addBranches(@RequestBody Branches branches) {
        return this.branchesService.addBranches(branches);
    }
    @GetMapping(path = "/{id}")
    public Optional<Branches> getBranchesById(@PathVariable("id") Long id) {
        return this.branchesService.getBranchesById(id);
    }

    @PutMapping(path = "/{id}")
    public Branches updateBranches(@RequestBody Branches branches,@PathVariable("id") Long id) {
        return  this.branchesService.updateBranches(branches,id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteBranches(@PathVariable("id") Long id) {
        boolean ok=this.branchesService.deleteBranches(id);
        if(ok){
            return "Branches with id"+" "+id+" "+"deleted";
        }else {
            return "Error, we have a problem";
        }
    }
}
