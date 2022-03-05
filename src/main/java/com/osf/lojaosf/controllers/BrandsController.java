package com.osf.lojaosf.controllers;

import com.osf.lojaosf.models.entities.Brands;
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

    @RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT })
    public @ResponseBody Brands saveBrands(@Valid Brands brands) {
        brandsRepository.save(brands);
        return brands;
    }

    @GetMapping
    public Iterable<Brands> getAllProducts() {
        return brandsRepository.findAll();
    }

    @GetMapping(path = "/name/{partName}")
    public Iterable<Brands> getStoresByName(@PathVariable String partName) {
        return brandsRepository.searchByNameLike(partName);
    }

    @GetMapping("/page/{numberPage}/{qtdPage}")
    public Iterable<Brands> getProductsPerPage(@PathVariable int numberPage, @PathVariable int qtdPage) {
        if (qtdPage >= 5) {
            qtdPage = 5;
        }

        Pageable page = PageRequest.of(numberPage, 2);
        return brandsRepository.findAll(page);

    }

    @GetMapping("/{id}")
    public Optional<Brands> getProductsById(@PathVariable int id) {
        return brandsRepository.findById(id);
    }



    @DeleteMapping("/{id}")
    public void deleteProductsById(@PathVariable int id) {
        brandsRepository.deleteById(id);
    }
}
