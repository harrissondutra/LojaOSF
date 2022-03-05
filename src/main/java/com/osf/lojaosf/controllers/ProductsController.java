package com.osf.lojaosf.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.osf.lojaosf.models.entities.Brands;
import com.osf.lojaosf.models.entities.Products;
import com.osf.lojaosf.models.entities.Stores;
import com.osf.lojaosf.models.repositories.BrandsRepository;
import com.osf.lojaosf.models.repositories.ProductsRepository;
import com.osf.lojaosf.models.repositories.StoreRepository;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

	@Autowired
	private ProductsRepository productsRepository;

	@Autowired
	private StoreRepository storeRepository;

	@Autowired
	private BrandsRepository brandsRepository;

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT })
	public @ResponseBody Products salvarProduto(@Valid Products produto) {
		productsRepository.save(produto);
		return produto;
	}

	@GetMapping
	public Iterable<Products> getAllProducts() {
		return productsRepository.findAll();
	}

	@GetMapping(path = "/name/{partName}")
	public Iterable<Products> getProductsByName(@PathVariable String partName) {
		return productsRepository.searchByNameLike(partName);
	}

	@GetMapping(path = "/name/{Stores}")
	public Iterable<Stores> getProductsByStore(@PathVariable String stores) {
		return storeRepository.searchByNameStore(stores);
	}

	@GetMapping(path = "/name/{Brands}")
	public Iterable<Brands> getProductsByBrands(@PathVariable String brands) {
		return brandsRepository.searchByNameLike(brands);
	}

	@GetMapping("/page/{numberPage}/{qtdPage}")
	public Iterable<Products> getProductsPerPage(@PathVariable int numberPage, @PathVariable int qtdPage) {
		if (qtdPage >= 5) {
			qtdPage = 5;
		}

		Pageable page = PageRequest.of(numberPage, 2);
		return productsRepository.findAll(page);

	}

	@GetMapping("/{id}")
	public Optional<Products> getProductsById(@PathVariable int id) {
		return productsRepository.findById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteProductsById(@PathVariable int id) {
		productsRepository.deleteById(id);
	}
}
