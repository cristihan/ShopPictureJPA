package com.shop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.shop.utilities.InvalidParamException;

import com.shop.domain.Picture;

@Entity(name ="Shop")
public class Shop {
	
	private static int lastId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="shopId")
	private Integer shopId;
	@Column(name="nameShop")
	private String nameShop;
	@Column(name="maxCapacity")
	private int maxCapacity;
	
	@OneToMany(targetEntity = Picture.class)
	@JoinColumn(name = "shop_id")
	private List<Picture> allPictures = new ArrayList<Picture>();
	
	public Shop() {
		
	}
	
	public Shop(String nameShop, int maxCapacity) throws InvalidParamException {
		if(nameShop == null || nameShop.trim().equals(""))
			throw new InvalidParamException();
		if(maxCapacity < 0)
			throw new InvalidParamException();
		
		this.shopId = lastId;
		lastId++;
		this.nameShop = nameShop;
		this.maxCapacity = maxCapacity;
	}


	public Integer getShopId() {
		return shopId;
	}

	public List<Picture> getAllPictures() {
		return new ArrayList<>(allPictures);
	}

	public String getNameShop() {
		return nameShop;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}
	
	public void addPicture(Picture picture) throws InvalidParamException {
		if(picture == null) 
			throw new InvalidParamException(); 
		if(this.maxCapacity == this.allPictures.size())
			throw new InvalidParamException();
		this.allPictures.add(picture);		
		
	}
	
	public void burnPictures() {
		this.allPictures.removeAll(allPictures);
	}
	
	

}
