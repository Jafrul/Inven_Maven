/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ati.inventory.service;

import com.ati.inventory.dao.ProductDAO;
import com.ati.inventory.model.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author User
 */
 @Service
 @Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;
    
    @Override
    public List<Product> get() {
       List<Product> list = productDAO.findAll();
       return list;
    }

    @Override
    public void save(Product product) {
        
      productDAO.save(product);
       
    }

    @Override
    public Product edit(int id) {
   return  productDAO.findById(id).get();
     
    }

    @Override
    public void delete(int id) {
         productDAO.deleteById(id);
    }
    
}
