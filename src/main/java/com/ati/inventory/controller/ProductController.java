/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ati.inventory.controller;

import com.ati.inventory.model.Product;

import com.ati.inventory.service.ProductService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author User
 */
@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String get(Model model) {

        List<Product> list = productService.get();
        model.addAttribute("list", list);

        return "index";
    }

    @GetMapping("/showForm")
    public String addProduct(@Valid Product product, Model model) {

        model.addAttribute("product", new Product());

        return "add";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product) {

        productService.save(product);

        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable("id") Integer id, Model model) {

        Product product = productService.edit(id);
        model.addAttribute("product", product);

        return "sale";
    }

    @PostMapping("/update/{id}")
    public String editProduct(@PathVariable("id") Integer id, Product product) {
  
   
        productService.save(product);
           
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id) {
        productService.delete(id);

        return "redirect:/";
    }
    
 

}
