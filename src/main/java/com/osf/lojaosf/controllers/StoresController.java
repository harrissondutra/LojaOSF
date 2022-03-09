package com.osf.lojaosf.controllers;

import com.osf.lojaosf.models.entities.Store;
import com.osf.lojaosf.models.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/stores")
public class StoresController {

    @Autowired
    private StoreRepository storeRepository;

    @RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT })
    public @ResponseBody
    Store saveStores(@Valid Store store) {
        storeRepository.save(store);
        return store;
    }

    @GetMapping
    public Iterable<Store> getAllStores() {
        return storeRepository.findAll();
    }

    @GetMapping(path = "/name/{partName}")
    public Iterable<Store> getStoresByName(@PathVariable String partName) {
        return storeRepository.searchByNameLike(partName);
    }

    @GetMapping(path = "/name/{Stores}")
    public Iterable<Store> getProductsByStore(@PathVariable String Stores) {
        return storeRepository.searchByNameStore(Stores);
    }

    @GetMapping("/page/{numberPage}/{qtdPage}")
    public Iterable<Store> getStoresPerPage(@PathVariable int numberPage, @PathVariable int qtdPage) {
        if (qtdPage >= 5) {
            qtdPage = 5;
        }

        Pageable page = PageRequest.of(numberPage, 2);
        return storeRepository.findAll(page);

    }

    @GetMapping("/{id}")
    public Optional<Store> getStoresById(@PathVariable int id) {
        return storeRepository.findById(id);
    }



    @DeleteMapping("/{id}")
    public void deleteStoresById(@PathVariable int id) {
        storeRepository.deleteById(id);
    }
}
