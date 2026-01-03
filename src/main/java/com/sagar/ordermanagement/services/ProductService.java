package com.sagar.ordermanagement
.services;


import com.sagar.ordermanagement
.dto.ProductDTO;
import java.util.List;

public interface ProductService {
     List<ProductDTO> findAll();

    ProductDTO findById(Long id);
    
    ProductDTO insert(ProductDTO dto);

    void delete(Long id);
}

