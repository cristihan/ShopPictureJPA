package com.shop.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shop.application.PictureController;
import com.shop.application.dto.PictureDTO;

@RestController
@CrossOrigin
@RequestMapping("/shops/{shopID}/pictures")//Esta Peticion URL afectara a toda las peticiones de la clase
public class PictureRestController {

	@Autowired
	private PictureController controller;

	// Añadir cuadro, le daremos nombre de cuadro y de autor: POST
	// /shops/{ID}/pictures
	@PostMapping(produces = "application/json;charset=UTF-8")
	public String addPicture(@PathVariable int shopID, @RequestBody String jPicture) throws Exception {

		PictureDTO newPicture = new Gson().fromJson(jPicture, PictureDTO.class);
		PictureDTO picture = controller.createPicture(shopID, newPicture);

		return toJson(picture);
	}

	private String toJson(Object object) {
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(object);
	}

	// Listar los cuadros de la tienda: GET /shops/{ID}/pictures
	@GetMapping(produces = "application/json;charset=UTF-8")
	public String listPicturesShopID(@PathVariable int shopID) throws Exception {

		List<PictureDTO> pictures = controller.getAllPictures(shopID);
		return toJson(pictures);
	}

}
