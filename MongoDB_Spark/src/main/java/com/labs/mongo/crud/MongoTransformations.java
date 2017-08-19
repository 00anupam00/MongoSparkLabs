package com.labs.mongo.CRUD;

import com.mongodb.spark.rdd.api.java.JavaMongoRDD;
import org.apache.spark.sql.Dataset;
import scala.Tuple2;

import java.util.List;

/**
 * Created by anupamrakshit on 27/04/17.
 */
public class MongoTransformations {
    private JavaMongoRDD mongoDoc;

    public MongoTransformations(JavaMongoRDD mongoDoc){
        this.mongoDoc= mongoDoc;
    }
    public JavaMongoRDD getMongoDoc(){
        return this.mongoDoc;
    }

    public Tuple2<String, Integer> breakoutCrew(){
        Tuple2<String, Integer> breakOut= null;
                   Dataset<JavaMongoRDD>dfCrew= this.mongoDoc.toDF().select("Crew", "Duration");
                   Dataset<JavaMongoRDD>dfTime= this.mongoDoc.toDF().select("Duration");

                   List<JavaMongoRDD> rddList= dfCrew.takeAsList((int)dfCrew.count());

                   dfCrew.show();
                   dfTime.show();

        return  breakOut;
    }
}
