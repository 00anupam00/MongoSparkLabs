package com.labs.mongo.crud;

import com.mongodb.spark.rdd.api.java.JavaMongoRDD;
import org.junit.Before;
import org.junit.Test;
import scala.Tuple2;

/**
 * Created by anupamrakshit on 28/05/17.
 */
public class MongoTransformationsTest {

	JavaMongoRDD mongoRDD;

	@Before
	public void setUp(){
		mongoRDD= new MongoCRUD().readMongoDoc();
		System.out.println("First sample doc: "+mongoRDD.first());
	}

	@Test
	public void testBreakOut(){
		Tuple2<String, Integer> breakOut= new MongoTransformations(mongoRDD).breakoutCrew();
		System.out.println(breakOut);
	}
}
