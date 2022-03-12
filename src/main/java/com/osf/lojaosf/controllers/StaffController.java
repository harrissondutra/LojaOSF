package com.osf.lojaosf.controllers;

import com.osf.lojaosf.models.entities.Staff;
import com.osf.lojaosf.models.repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    @Autowired
    private StaffRepository staffRepository;


    @GetMapping
    public Iterable<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    @GetMapping(path = "/name/{partName}")
    public Iterable<Staff> getStaffByName(@PathVariable String partName) {
        return staffRepository.searchByNameLike(partName);
    }

    @GetMapping("/{id}")
    public Optional<Staff> getStaffById(@PathVariable int id) {
        return staffRepository.findById(id);
    }

    @PostMapping
    public @ResponseBody
    Staff saveStaff(@Valid Staff staff) {
        staffRepository.save(staff);
        return staff;
    }

    @PutMapping
    public Staff changeStaff(@Valid Staff staff){
        staffRepository.save(staff);
        return staff;
    }

    @DeleteMapping("/{id}")
    public void deleteStaffById(@PathVariable int id) {
        staffRepository.deleteById(id);
    }
}
