package com.shop.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.shop.utilities.InvalidParamException;

@Entity(name ="Picture")
public class Picture {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="pictureId")
	private Integer pictureId;
	@Column(name="nameAuthor")
	private String nameAuthor;
	@Column(name="namePicture")
	private String namePicture;
	@Column(name="price")
	private double price;
	
	
	
	private Calendar dataIn;
	
	public Picture() {
		
	}
	
	public Picture(String nameAuthor, String namePicture, double price) throws InvalidParamException {
		if(nameAuthor == null || nameAuthor.trim().equals(""))
			throw new InvalidParamException();
		if(namePicture == null || namePicture.trim().equals(""))
			throw new InvalidParamException();
		if(price < 0)
			throw new InvalidParamException();		
		this.nameAuthor = nameAuthor;
		this.namePicture = namePicture;
		this.price = price;
		this.dataIn = Calendar.getInstance();
	}
	
	
	public Integer getPictureId() {
		return pictureId;
	}

	public String getNameAuthor() {
		return nameAuthor;
	}

	public String getNamePicture() {
		return namePicture;
	}

	public double getPrice() {
		return price;
	}

	public Calendar getDateIn() {
		return dataIn;
	}

	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}



}
	
