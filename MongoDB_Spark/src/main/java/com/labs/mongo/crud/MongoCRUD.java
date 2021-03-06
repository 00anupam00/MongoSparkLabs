package com.labs.mongo.CRUD;

import com.labs.mongo.ApplicationConfig;
import com.labs.mongo.commons.Constants;
import com.mongodb.spark.MongoSpark;
import com.mongodb.spark.rdd.api.java.JavaMongoRDD;
import org.bson.Document;
import org.springframework.stereotype.Service;


/**
 * Created by anupamrakshit on 27/04/17.
 */
@Service
public class MongoCRUD {

    private String mongo_connection= Constants.Mongo_URL+Constants.Mongo_DATABASE_NAME+"."+Constants.Mongo_COLLECTION_NAME;

    /**
     * Read from MongoDB
     * @return JavaMongoRDD
     */
    public JavaMongoRDD readMongoDoc(){
        JavaMongoRDD<Document> eva= MongoSpark.load(ApplicationConfig.getJavaSparkContext());
        return eva;
    }

    /**
     * Write to MongoDB
     */
    public void writeToMongo(){
//        Dataset<Row> csvDs= ApplicationConfig.getSparkSession().sqlContext()
//                .read()
//                .format("csv")
//                .option("header", "true") //assumes first row as header
//                .load("src/main/resources/data/EVA_.csv");
//        MongoSpark.save(
//                csvDs.write().mode(SaveMode.Overwrite),
//                new WriteConfig(Constants.Mongo_DATABASE_NAME, Constants.Mongo_COLLECTION_NAME, Option.apply(mongo_connection), 20,
//                new WriteConcernConfig(Option.empty(), Option.empty(), Option.empty(),Option.empty())));
    }
}