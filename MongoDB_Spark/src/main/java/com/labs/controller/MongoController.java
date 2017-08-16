package com.labs.controller;

import com.labs.mongo.crud.MongoCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by anupamrakshit on 15/08/17.
 */
@RestController
public class MongoController {

    @Autowired
	MongoCRUD crud;

	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public ResponseEntity getMongoData(){
		try{
			return ResponseEntity.ok(crud.readMongoDoc().take(100));
		}catch (Exception e){
			return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
		}
	}
}
