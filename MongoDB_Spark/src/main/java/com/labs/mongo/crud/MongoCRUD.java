package com.labs.mongo.CRUD;

import com.labs.mongo.ApplicationConfig;
import com.mongodb.spark.MongoSpark;
import com.mongodb.spark.rdd.api.java.JavaMongoRDD;
import org.apache.spark.sql.Dataset;
import org.bson.Document;
import org.springframework.stereotype.Service;

/**
 * Created by anupamrakshit on 27/04/17.
 */
@Service
public class MongoCRUD {

    public JavaMongoRDD readMongoDoc(){
        JavaMongoRDD<Document> eva= MongoSpark.load(ApplicationConfig.getJavaSparkContext());
        System.out.println("First Document: "+eva.first().toJson());
        System.out.println("Count: "+eva.count());
        return eva;
    }

    public void writeToMongo(){
        Dataset<Document> df;

    }
}
