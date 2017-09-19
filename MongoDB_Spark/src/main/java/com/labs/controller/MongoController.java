package com.labs.controller;

import com.labs.mongo.CRUD.MongoCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by anupamrakshit on 15/08/17.
 */
@RestController
@RequestMapping(value = "/api")
public class MongoController {

    @Autowired
	MongoCRUD crud;

	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public ResponseEntity getMongoData(){
		try{
			return ResponseEntity.ok(crud.readMongoDoc().take(50));
		}catch (Exception e){
			return ResponseEntity.status(500).body("Some Error has occured.");
		}
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity welcome(){
		return ResponseEntity.ok("Welcome to EVA Analysis, from JAVA");
	}
}
