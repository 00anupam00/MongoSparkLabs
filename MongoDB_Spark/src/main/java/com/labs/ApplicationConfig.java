package com.labs;

import com.labs.mongo.CRUD.MongoCRUD;
import com.labs.mongo.CRUD.MongoTransformations;
import com.mongodb.spark.rdd.api.java.JavaMongoRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;

/**
 * Created by anupamrakshit on 26/04/17.
 */
public class ApplicationConfig {

    public static final SparkSession sparkSession= getSparkSession();
    public static final JavaSparkContext jvc= getJavaSparkContext();

    public static SparkSession getSparkSession(){
        return SparkSession
                .builder()
                .master("local[*]")
                .appName("Mongo Spark Demo")
                .config("spark.mongodb.input.uri", "mongodb://127.0.0.1:8010/mongoSpark.EVA_")
                .config("spark.mongodb.output.uri", "mongodb://127.0.0.1:8010/mongoSpark.EVA_")
                .getOrCreate();
    }

    public static JavaSparkContext getJavaSparkContext(){
        return new JavaSparkContext(getSparkSession().sparkContext());
    }

    public static void main(String[] args) {
        JavaMongoRDD mongoRDD= new MongoCRUD().loadMongoDoc();
        new MongoTransformations(mongoRDD).breakoutCrew();

        System.out.println("** All Transformaions Complete. **");


    }
}
