package com.labs.mongo.crud;

import com.labs.mongo.ApplicationConfig;
import com.labs.mongo.commons.Constants;
import com.mongodb.spark.MongoSpark;
import com.mongodb.spark.config.WriteConcernConfig;
import com.mongodb.spark.config.WriteConfig;
import com.mongodb.spark.rdd.api.java.JavaMongoRDD;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SaveMode;
import org.bson.Document;
import scala.Option;

import java.io.File;

/**
 * Created by anupamrakshit on 27/04/17.
 */
public class MongoCRUD {

    private String mongo_connection= Constants.Mongo_URL+Constants.Mongo_DATABASE_NAME+"."+Constants.Mongo_COLLECTION_NAME;

    public JavaMongoRDD readMongoDoc(){
        JavaMongoRDD<Document> eva= MongoSpark.load(ApplicationConfig.jvc);
        return eva;
    }

    public void writeToMongo(){
        Dataset<Row> csvDs= ApplicationConfig.getSparkSession().sqlContext()
                .read()
                .format("csv")
                .option("header", "true") //assumes first row as header
                .load("src/main/resources/data/EVA_.csv");
        MongoSpark.save(
                csvDs.write().mode(SaveMode.Overwrite),
                new WriteConfig(Constants.Mongo_DATABASE_NAME, Constants.Mongo_COLLECTION_NAME, Option.apply(mongo_connection), 20,
                new WriteConcernConfig(Option.empty(), Option.empty(), Option.empty(),Option.empty())));
    }
}
