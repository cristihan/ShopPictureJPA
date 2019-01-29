package com.shop.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.domain.Picture;
import com.shop.utilities.InvalidParamException;


@Repository
public class PictureRepository {
	
	@Autowired
	private HelperPictureRepository repository;

	//private static List<Picture> repository = new ArrayList<>();

	public void addPicture(Picture picture) throws InvalidParamException {
		if (picture == null)
			throw new InvalidParamException();
		repository.save(picture);

	}

	/*public void burnPictures(int PictureId) {
		for (Picture picture : repository) {
			if (picture.getPictureId().equals(PictureId)) {
				repository.remove(PictureId);
			}

		}
	}*/

}
