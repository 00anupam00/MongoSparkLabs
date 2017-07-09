package com.labs.mongo;

import com.labs.mongo.commons.Constants;
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
                .appName("mongo Spark Demo")
                .config("spark.mongodb.input.uri", Constants.Mongo_URL+ Constants.Mongo_DATABASE_NAME + "." +Constants.Mongo_COLLECTION_NAME)
                .config("spark.mongodb.output.uri", "mongodb://127.0.0.1:27017/mongoSpark.EVA_")
                .getOrCreate();
    }

    public static JavaSparkContext getJavaSparkContext(){
        return new JavaSparkContext(getSparkSession().sparkContext());
    }

    public static void main(String[] args) {


        System.out.println("** All Transformations Complete. **");


    }
}
