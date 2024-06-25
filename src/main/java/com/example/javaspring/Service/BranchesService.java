package com.example.javaspring.Service;


import com.example.javaspring.Model.Branches;
import com.example.javaspring.Repository.BranchesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class BranchesService {
    @Autowired
    BranchesRepo branchesRepo;

    public ArrayList<Branches> getBranches() {
        return (ArrayList<Branches>) branchesRepo.findAll();
    }

    public Branches addBranches(Branches branches) {
        return branchesRepo.save(branches);
    }

    public Optional<Branches> getBranchesById(Long id) {
        return branchesRepo.findById(id);
    }

    public Branches updateBranches(Branches branches,Long id) {
        Branches branchesOptional = branchesRepo.findById(id).get();


        return branchesOptional;
    }

    public Boolean deleteBranches(Long id) {
        try {
            branchesRepo.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
