package com.shop.persistence;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.domain.Picture;
import com.shop.domain.Shop;
import com.shop.utilities.InvalidParamException;
import com.shop.utilities.NotFoundException;

import com.shop.persistence.HelperShopRepository;

@Repository
public class ShopRepository {
	
	
	@Autowired
	private HelperShopRepository repository;
	@Autowired
	private HelperPictureRepository pictureRepository;
	
	//private static List<Shop> shop = new ArrayList<>();

//	private static Datastore datastore = DatastoreManager.getInstance().getDatastore();
//	/**
//	 * crea una nueva botiga y si existe la guarda
//	 * 
//	 * @param shop
//	 * @throws InvalidParamException
//	 */
	public void addShop(Shop shop) throws InvalidParamException {
		if (shop == null)
			throw new InvalidParamException();
		try {
			repository.save(shop);
			//datastore.save(shop);
		} catch (Exception e) {
			throw new InvalidParamException();
		}
	}
	
	/*
	 * he creado un nuevo metodo para crear un cuadro
	 */
	public void addPicture(Picture picture) throws InvalidParamException {
		if (picture == null)
			throw new InvalidParamException();
		pictureRepository.save(picture);

	}
	

	public List<Shop> getAllShops() {
		List<Shop> result = new ArrayList<>();
		for (Shop s : repository.findAll()) {
			result.add(s);
		}
		return result;
		//return new ArrayList<>(repository);
		//return repository;	
	}
	
	public Shop getShopById(int shopId) throws NotFoundException {
		
		try {
				return repository.findById(shopId).get();
			}catch (Exception exception) {		
		throw new NotFoundException();
			}
	}
	
	
//
//		
//	public static Shop findShop(String id) {
//		return datastore.find(Shop.class).field("id").equal(id).get();
//	}

}
