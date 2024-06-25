package com.example.javaspring.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Branches")

public class Branches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nameBranch;

    @Column
    private String OpeningHours;

    @Column
    private String ContactNumber;

    @Column
    private String Location;

    public Branches() {
    }

    public Branches(Long id, String nameBranch, String openingHours, String contactNumber, String location) {
        this.id = id;
        this.nameBranch = nameBranch;
        OpeningHours = openingHours;
        ContactNumber = contactNumber;
        Location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameBranch() {
        return nameBranch;
    }

    public void setNameBranch(String nameBranch) {
        this.nameBranch = nameBranch;
    }

    public String getOpeningHours() {
        return OpeningHours;
    }

    public void setOpeningHours(String openingHours) {
        OpeningHours = openingHours;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        ContactNumber = contactNumber;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }
}
