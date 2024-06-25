package com.example.javaspring.Repository;

import com.example.javaspring.Model.Branches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchesRepo extends JpaRepository<Branches ,Long> {
}
