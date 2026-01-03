package com.sagar.ordermanagement
.services.impl;

import com.sagar.ordermanagement
.dto.ProductDTO;
import com.sagar.ordermanagement
.entities.Product;
import com.sagar.ordermanagement
.exceptions.ProductNotFoundException;
import com.sagar.ordermanagement
.repositories.ProductRepository;
import com.sagar.ordermanagement
.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    public ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProductDTO> findAll() {
        List<Product> prod = repository.findAll();
        return prod.stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    @Override
    public ProductDTO findById(Long id) throws ProductNotFoundException {
        return new ProductDTO(repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id)));
    }

    @Override
    public ProductDTO insert(ProductDTO dto) {
        var productSaved = repository.save(new Product(dto));
        return new ProductDTO(productSaved);
    }

    @Override
    public void delete(Long id) {
        this.findById(id);
        repository.deleteById(id);
    }
}
