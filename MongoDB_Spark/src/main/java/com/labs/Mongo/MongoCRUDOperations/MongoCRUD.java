package com.labs.Mongo.MongoCRUDOperations;

import com.labs.Mongo.ApplicationConfig;
import com.mongodb.spark.MongoSpark;
import com.mongodb.spark.rdd.api.java.JavaMongoRDD;
import org.apache.spark.sql.Dataset;
import org.bson.Document;

/**
 * Created by anupamrakshit on 27/04/17.
 */
public class MongoCRUD {

    public JavaMongoRDD loadMongoDoc(){
        JavaMongoRDD<Document> eva= MongoSpark.load(ApplicationConfig.jvc);
        System.out.println("First Document: "+eva.first().toJson());
        System.out.println("Count: "+eva.count());
        return eva;
    }

    public void writeMongoDoc(){
        Dataset<Document> df;

    }
}
