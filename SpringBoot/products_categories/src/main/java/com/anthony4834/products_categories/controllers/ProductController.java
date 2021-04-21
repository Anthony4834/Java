package com.anthony4834.products_categories.controllers;

import javax.validation.Valid;

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

import com.anthony4834.products_categories.models.Product;
import com.anthony4834.products_categories.services.CategoryServ;
import com.anthony4834.products_categories.services.ProductServ;

@Controller
public class ProductController {
	private final ProductServ serv;
	private final CategoryServ cServ;
	
	public ProductController(ProductServ s, CategoryServ cs) {
		this.serv = s;
		this.cServ = cs;
	}
	
	@GetMapping("/")
	public String index(Model m, @ModelAttribute("product") Product product) {
		return "/newProduct.jsp";
	}
	@PostMapping("/products/new")
	public String createProduct(Model m, @Valid @ModelAttribute("product") Product product, BindingResult result, RedirectAttributes redirect) {
		if(result.hasErrors()) {
			System.out.println("I should've taken C#");
			return "redirect:/";
		} else {
			serv.saveProduct(product);
			return "redirect:/";
		}
	}
	@GetMapping("/product/{id}")
	public String displayCat(Model m, @PathVariable("id") Long id) {
		m.addAttribute("product", serv.findProduct(id));
		m.addAttribute("categories", serv.findProduct(id).getCategories());
		m.addAttribute("potentialCats", cServ.findAllExcept(serv.findProduct(id)));
		return "/displayProduct.jsp";
	}
	@PutMapping("/product/{id}")
	public String addProdToCat(Model m, @RequestParam("category") Long cat, @PathVariable("id") Long id) {
		serv.addCategoryToProduct(serv.findProduct(id), cServ.findCat(cat));
		return "redirect:/product/" + id;
	}
}
