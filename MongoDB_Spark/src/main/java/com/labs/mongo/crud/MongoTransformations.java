package com.labs.mongo.CRUD;

import com.mongodb.spark.rdd.api.java.JavaMongoRDD;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.sql.Dataset;
import org.bson.Document;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by anupamrakshit on 27/04/17.
 */
public class MongoTransformations {
    private JavaMongoRDD mongoDoc;
    static Pattern pattern = Pattern.compile("(\\w+\\s\\w+)");

    public MongoTransformations(JavaMongoRDD mongoDoc) {
        this.mongoDoc = mongoDoc;
    }

    public JavaMongoRDD getMongoDoc() {
        return this.mongoDoc;
    }

    public Tuple2<String, Integer> breakoutCrew() {
        Tuple2<String, Integer> breakOut = null;
        Dataset<JavaMongoRDD> dfCrew = this.mongoDoc.toDF().select("Crew", "Duration");
        Dataset<JavaMongoRDD> dfTime = this.mongoDoc.toDF().select("Duration");

        List<JavaMongoRDD> rddList = dfCrew.takeAsList((int) dfCrew.count());

                 /*  dfCrew.show();
                   dfTime.show();*/

        return breakOut;
    }

    /*private void save() {

        JavaPairRDD<String, Integer> logs = mongoDoc.flatMapToPair(
                new PairFlatMapFunction<Document, String, Integer>
                        () {
                    @Override
                    public Iterable<Tuple2<String, Integer>> call(Document document) throws Exception {
                        int minutes = 0;
                        String time = (String) document.get("Duration");
                        if (!time.isEmpty()) {
                            String[] timeComponents = time.split(":");
                            minutes = (new Integer(timeComponents[0]) * 60);
                            minutes += (new Integer(timeComponents[1]));
                        }

                        String crewString = (String) document.get("Crew");
                        Matcher matcher = pattern.matcher(crewString);
                        List<String> crew = new ArrayList<>();

                        while (matcher.find()) {
                            crew.add(matcher.group());
                        }

                        final int finalMinutes = minutes;
                        return crew.stream()
                                .map(new Function<String, Tuple2<String, Integer>>() {
                                    @Override
                                    public Tuple2<String, Integer> apply(String c) {
                                        return new Tuple2<String, Integer>(c, finalMinutes);
                                    }
                                })
                                .collect(Collectors.<Tuple2<String, Integer>>toList());
                    }
                });

        JavaPairRDD<String, Integer> totalHours = logs.reduceByKey(
                new Function2<Integer, Integer, Integer>() {
                    @Override
                    public Integer call(Integer v1, Integer v2) throws Exception {
                        return v1 + v2;
                    }
                }
        );

        FlatMapFunction map = new FlatMapFunction<Tuple2<String, Integer>, Document>() {
            @Override
            public List<Document> call(Tuple2<String, Integer> tuple) throws Exception {
                Document doc = new Document();
                doc.put("_id", tuple._1);
                doc.put("minutes", tuple._2);
                List<Document> docs = new ArrayList<Document>();
                docs.add(doc);
                return docs;
            }
        };

        JavaRDD<Document> records = totalHours.flatMap(map);

        totalHours.foreach(
                new VoidFunction<Tuple2<String, Integer>>() {
                    @Override
                    public void call(Tuple2<String, Integer> tuple) throws Exception {
                        System.out.println(tuple._1 + " " + tuple._2);
                    }
                }
        );

        WriteConfig defaultWriteConfig = WriteConfig.create(jsc);
        Map<String, String> writeOverrides = new HashMap<String, String>();
        writeOverrides.put("collection", "astronautTotals");
        writeOverrides.put("databaseName", "nasa");
        writeOverrides.put("writeConcern.w", "majority");
        WriteConfig writeConfig = WriteConfig.create(writeOverrides, defaultWriteConfig);

        MongoSpark.save(records, writeConfig);

    }*/
}
