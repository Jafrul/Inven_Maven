/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ati.inventory.service;

import com.ati.inventory.model.Product;
import java.util.List;





public interface ProductService {
    List<Product> get();

    void save(Product product);
    Product edit(int id);
 
    void delete(int id);
}
