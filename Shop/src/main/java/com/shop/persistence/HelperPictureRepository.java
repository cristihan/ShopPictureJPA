package com.shop.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.shop.domain.Shop;
import com.shop.domain.Picture;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

interface HelperPictureRepository extends CrudRepository<Picture, Integer> {


}
