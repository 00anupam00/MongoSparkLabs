package com.labs.mongo.crud;

import com.mongodb.spark.rdd.api.java.JavaMongoRDD;
import org.junit.Test;

/**
 * Created by anupamrakshit on 27/05/17.
 */
public class MongoCrudTest {

	/**
	 * Load the doc using mongoimport as:
	 * mongoimport /Users/anupamrakshit/Documents/study/Spark_MongoDB/MongoSparkLabs/MongoDB_Spark/src/main/java/resources/data/EVA_.csv --type csv --headerline -d mongoSpark -c EVA_
	 */
	JavaMongoRDD mongoRDD;

	@Test
	public void testWritetomongoDB(){
		new MongoCRUD().writeToMongo();
		System.out.println("First sample doc: "+mongoRDD.first());
	}

	@Test
	public void testShowFirstDoc(){
		mongoRDD= new MongoCRUD().readMongoDoc();
		System.out.println("First sample doc: "+mongoRDD.first());
	}


}
