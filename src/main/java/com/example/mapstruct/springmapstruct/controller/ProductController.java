package com.example.mapstruct.springmapstruct.controller;

import com.example.mapstruct.springmapstruct.Product;
import com.example.mapstruct.springmapstruct.ProductDto;
import com.example.mapstruct.springmapstruct.ProductMapper;
import com.example.mapstruct.springmapstruct.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/products")
    public ResponseEntity<Product> create(@RequestBody ProductDto productDto) {
        return new ResponseEntity<>(productRepository.save(
                productMapper.productDtoToProduct(productDto)), HttpStatus.CREATED);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> findAll() {
        return new ResponseEntity<>(productMapper.toDtos(
                productRepository.findAll()), HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(productMapper.toDto(
                productRepository.findById(id).get()), HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(value = "id") int id) {
        ProductDto productDto = productMapper.toDto(productRepository.findById(id).get());
        productRepository.deleteById(productDto.getId());
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}


