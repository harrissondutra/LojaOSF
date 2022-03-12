package com.osf.lojaosf.controllers;

import com.osf.lojaosf.models.entities.Brand;
import com.osf.lojaosf.models.repositories.BrandsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {

    @Autowired
    private BrandsRepository brandsRepository;

    @GetMapping
    public Iterable<Brand> getAllBrands() {
        return brandsRepository.findAll();
    }

    @GetMapping(path = "/name/{partName}")
    public Iterable<Brand> getBrandsByName(@PathVariable String partName) {
        return brandsRepository.searchByNameLike(partName);
    }

    @GetMapping("/page/{numberPage}/{qtdPage}")
    public Iterable<Brand> getBrandsPerPage(@PathVariable int numberPage, @PathVariable int qtdPage) {
        if (qtdPage >= 5) {
            qtdPage = 5;
        }
        Pageable page = PageRequest.of(numberPage, 2);
        return brandsRepository.findAll(page);
    }

    @GetMapping("/{id}")
    public Optional<Brand> getBrandsById(@PathVariable int id) {
        return brandsRepository.findById(id);
    }

    @PostMapping
    public @ResponseBody
    Brand saveBrands(@Valid Brand brand) {
        brandsRepository.save(brand);
        return brand;
    }

    @PutMapping
    public Brand changeBrands(@Valid Brand brand){
        brandsRepository.save(brand);
        return brand;
    }

    @DeleteMapping("/{id}")
    public void deleteBrandsById(@PathVariable int id) {
        brandsRepository.deleteById(id);
    }
}
