package com.osf.lojaosf.controllers;

import com.osf.lojaosf.models.entities.Product;
import com.osf.lojaosf.models.entities.Stock;
import com.osf.lojaosf.models.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    private StockRepository stockRepository;

    @GetMapping
    public Iterable<Stock> getAllStocks() {
        return stockRepository.findAll();
    }


    @GetMapping("/page/{numberPage}/{qtdPage}")
    public Iterable<Stock> getStocksPerPage(@PathVariable int numberPage, @PathVariable int qtdPage) {
        if (qtdPage >= 5) {
            qtdPage = 5;
        }
        Pageable page = PageRequest.of(numberPage, 2);
        return stockRepository.findAll(page);
    }

    @GetMapping("/{id}")
    public Optional<Stock> getStocksById(@PathVariable int id) {
        return stockRepository.findById(id);
    }

    @PostMapping
    public @ResponseBody
    Stock saveStocks(@Valid Stock stock) {
        Product product = new Product();
        if(product.getId() == null){
            throw new IllegalArgumentException("Is Necessary one product to create a Stock");
        }
        stockRepository.save(stock);
        return stock;
    }

    @PutMapping
    public Stock changeStocks(@Valid Stock stock){
        stockRepository.save(stock);
        return stock;
    }

    @DeleteMapping("/{id}")
    public void deleteStocksById(@PathVariable int id) {
        stockRepository.deleteById(id);
    }
}
