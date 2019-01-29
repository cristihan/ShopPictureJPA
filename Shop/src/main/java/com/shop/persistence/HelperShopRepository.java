package com.shop.persistence;

import org.springframework.data.repository.CrudRepository;

import com.shop.domain.Shop;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

interface HelperShopRepository extends CrudRepository<Shop, Integer> {


	
}
