package com.anthony4834.products_categories.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.anthony4834.products_categories.models.Category;
import com.anthony4834.products_categories.models.Product;
import com.anthony4834.products_categories.repositories.CategoryRepo;
import com.anthony4834.products_categories.repositories.ProductRepo;

@Service
public class ProductServ {
	private ProductRepo repo;
	private CategoryRepo catRepo;
	
	public ProductServ(ProductRepo r, CategoryRepo cR) {
		this.repo = r;
		this.catRepo = cR;
	}
	
	public List<Product> findAll() {
		return repo.findAll();
	}
	public Product saveProduct(Product p) {
		return repo.save(p);
	}
	public Product findProduct(Long id) {
		Product p = null;
		Optional<Product> opP = repo.findById(id);
		if(opP.isPresent()) {
			p = opP.get(); 
		}
		return p;
	}
	public Product addCategoryToProduct(Product p, Category cat) {
		p.getCategories().add(cat);
		return repo.save(p);
	}
	public List<Product> findAllExcept(Category cat) {
		List<Product> allProducts = this.findAll();
		List<Product> includedProducts = new ArrayList<Product>();
		allProducts.forEach((product) -> {
			List<Category> cats = product.getCategories();
			if(!cats.contains(cat)) {
				includedProducts.add(product);
			}
		});
		
		return includedProducts;
		
	}

}
