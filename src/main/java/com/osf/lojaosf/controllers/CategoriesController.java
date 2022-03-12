package com.osf.lojaosf.controllers;

import com.osf.lojaosf.models.entities.Category;
import com.osf.lojaosf.models.repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/category")
public class CategoriesController {

	@Autowired
	private CategoriesRepository categoriesRepository;

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

	@PostMapping
	public @ResponseBody Category saveCategory(@Valid Category category) {
		categoriesRepository.save(category);
		return category;
	}

	@PutMapping
	public Category changeCategory(@Valid Category category){
		categoriesRepository.save(category);
		return category;
	}

	@DeleteMapping("/{id}")
	public void deleteCategoryById(@PathVariable int id) {
		categoriesRepository.deleteById(id);
	}
}
