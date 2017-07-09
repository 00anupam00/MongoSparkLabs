package com.labs.mongo;

import com.labs.mongo.commons.Constants;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;

/**
 * Created by anupamrakshit on 26/04/17.
 */
public class ApplicationConfig {

    private static SparkSession sparkSession;
    private static JavaSparkContext jvc;
    private static SparkContext sparkContext;

    public static SparkSession getSparkSession(){
        if(sparkSession == null) {
            sparkSession = SparkSession
                    .builder()
                    .master("local[*]")
                    .appName("mongo Spark Demo")
                    .config("spark.mongodb.input.uri", Constants.Mongo_URL + Constants.Mongo_DATABASE_NAME + "." + Constants.Mongo_COLLECTION_NAME)
                    .config("spark.mongodb.output.uri", Constants.Mongo_URL + Constants.Mongo_DATABASE_NAME + "." + Constants.Mongo_COLLECTION_NAME)
                    .getOrCreate();
        }
        return sparkSession;
    }

    public static JavaSparkContext getJavaSparkContext(){
        if(jvc == null)
            jvc= new JavaSparkContext(getSparkSession().sparkContext());
        return jvc;
    }

    public static SparkContext getSparkContext(){
        if(sparkContext == null)
            sparkContext= getSparkSession().sparkContext();
        return sparkContext;
    }
}
