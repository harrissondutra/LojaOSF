package com.osf.lojaosf.controllers;

import com.osf.lojaosf.models.entities.Brand;
import com.osf.lojaosf.models.entities.Product;
import com.osf.lojaosf.models.entities.Store;
import com.osf.lojaosf.models.repositories.BrandsRepository;
import com.osf.lojaosf.models.repositories.ProductsRepository;
import com.osf.lojaosf.models.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

	@Autowired
	private ProductsRepository productsRepository;

	@Autowired
	private StoreRepository storeRepository;

	@Autowired
	private BrandsRepository brandsRepository;

	@GetMapping
	public Iterable<Product> getAllProducts() {
		return productsRepository.findAll();
	}

	@GetMapping(path = "/name/{partName}")
	public Iterable<Product> getProductsByName(@PathVariable String partName) {
		return productsRepository.searchByNameLike(partName);
	}

	@GetMapping(path = "/name/{Stores}")
	public Iterable<Store> getProductsByStore(@PathVariable String stores) {
		return storeRepository.searchByNameStore(stores);
	}

	@GetMapping(path = "/name/{Brands}")
	public Iterable<Brand> getProductsByBrands(@PathVariable String brands) {
		return brandsRepository.searchByNameLike(brands);
	}

	@GetMapping("/page/{numberPage}/{qtdPage}")
	public Iterable<Product> getProductsPerPage(@PathVariable int numberPage, @PathVariable int qtdPage) {
		if (qtdPage >= 5) {
			qtdPage = 5;
		}
		Pageable page = PageRequest.of(numberPage, 2);
		return productsRepository.findAll(page);
	}

	@GetMapping("/{id}")
	public Optional<Product> getProductsById(@PathVariable int id) {
		return productsRepository.findById(id);
	}

	@PostMapping
	public @ResponseBody
	Product salvarProduto(@Valid Product produto) {
		productsRepository.save(produto);
		return produto;
	}

	@PutMapping
	public Product changeProduct(@Valid Product product){
		productsRepository.save(product);
		return product;
	}
	@DeleteMapping("/{id}")
	public void deleteProductsById(@PathVariable int id) {
		productsRepository.deleteById(id);
	}
}
