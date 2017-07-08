package com.labs.mongo;

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
                .config("spark.mongodb.input.uri", "mongodb://127.0.0.1:27017/mongoSpark.EVA_")
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
