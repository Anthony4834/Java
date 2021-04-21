package com.anthony4834.products_categories.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.anthony4834.products_categories.models.Category;
import com.anthony4834.products_categories.models.Product;
import com.anthony4834.products_categories.repositories.CategoryRepo;

@Service
public class CategoryServ {
	private final CategoryRepo repo;
	
	public CategoryServ(CategoryRepo r) {
		this.repo = r;
	}
	
	public List<Category> findAll() {
		return repo.findAll();
	}
	public Category saveCategory(Category c) {
		return repo.save(c);
	}
	public Category findCat(Long id) {
		Category cat = null;
		Optional<Category> opCat = repo.findById(id);
		if(opCat.isPresent()) {
			cat = opCat.get(); 
		}
		return cat;
	}
	public List<Category> findAllExcept(Product p) {
		List<Category> allCats = this.findAll();
		List<Category> includedCats = new ArrayList<Category>();
		allCats.forEach((cat) -> {
			List<Product> prods = cat.getProducts();
			if(!prods.contains(p)) {
				includedCats.add(cat);
			}
		});
		
		return includedCats;
		
	}
}
