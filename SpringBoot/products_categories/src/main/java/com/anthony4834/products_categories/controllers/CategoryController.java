package com.anthony4834.products_categories.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.anthony4834.products_categories.models.Category;
import com.anthony4834.products_categories.models.Product;
import com.anthony4834.products_categories.services.CategoryServ;
import com.anthony4834.products_categories.services.ProductServ;

@Controller
public class CategoryController {
	private final CategoryServ serv;
	private final ProductServ pServ;
	
	public CategoryController(CategoryServ s, ProductServ pS) {
		this.serv = s;
		this.pServ = pS;
	}
	
	@GetMapping("/categories")
	public String catIndex(Model m, @ModelAttribute("category") Category cat) {
		return "newCategory.jsp";
	}
	@GetMapping("/category/{id}")
	public String displayCat(Model m, @PathVariable("id") Long id) {
		m.addAttribute("category", serv.findCat(id));
		m.addAttribute("products", serv.findCat(id).getProducts());
		m.addAttribute("potentialProducts", pServ.findAllExcept(serv.findCat(id)));
		return "/displayCategory.jsp";
	}
	@PutMapping("/category/{id}")
	public String addProdToCat(Model m, @RequestParam("product") Long prod, @PathVariable("id") Long id) {
		pServ.addCategoryToProduct(pServ.findProduct(prod), serv.findCat(id));
		return "redirect:/category/" + id;
	}
	@PostMapping("/categories/new")
	public String createCat(Model m, @ModelAttribute("category") Category cat, BindingResult result, RedirectAttributes redirect) {
		if(result.hasErrors()) {
			System.out.println("NAh");
			return "redirect:/categories";
		} else {
			serv.saveCategory(cat);
			return "redirect:/categories";
		}
	}
}
