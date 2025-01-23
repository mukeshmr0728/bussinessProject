package com.data.testing.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Products, Long> {
    @Override
    Optional<Products> findById(Long aLong);
    Optional<Products> findByName(Products products);
}
