package com.example.mapstruct.springmapstruct.repository;

import com.example.mapstruct.springmapstruct.Product;
import com.example.mapstruct.springmapstruct.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
