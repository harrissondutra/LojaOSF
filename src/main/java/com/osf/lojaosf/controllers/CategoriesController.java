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

import com.osf.lojaosf.models.entities.Category;
import com.osf.lojaosf.models.repositories.CategoriesRepository;

@RestController
@RequestMapping("/api/category")
public class CategoriesController {

	@Autowired
	private CategoriesRepository categoriesRepository;

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT })
	public @ResponseBody Category saveCategory(@Valid Category category) {
		categoriesRepository.save(category);
		return category;
	}

	@GetMapping
	public Iterable<Category> getAllProducts() {
		return categoriesRepository.findAll();
	}

	@GetMapping(path = "/name/{partName}")
	public Iterable<Category> getCategoryByName(@PathVariable String partName) {
		return categoriesRepository.searchByNameLike(partName);
	}

	@GetMapping("/page/{numberPage}/{qtdPage}")
	public Iterable<Category> getCategoryPerPage(@PathVariable int numberPage, @PathVariable int qtdPage) {
		if (qtdPage >= 5) {
			qtdPage = 5;
		}

		Pageable page = PageRequest.of(numberPage, 2);
		return categoriesRepository.findAll(page);

	}

	@GetMapping("/{id}")
	public Optional<Category> getCategoryById(@PathVariable int id) {
		return categoriesRepository.findById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteCategoryById(@PathVariable int id) {
		categoriesRepository.deleteById(id);
	}
}
