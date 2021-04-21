package com.anthony4834.products_categories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anthony4834.products_categories.models.Category;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Long> {
	public List<Category> findAll();
}
