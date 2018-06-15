package com.edutilos.main;

import com.edutilos.main.serializer.WorkerCSVSerializer;
import com.edutilos.main.serializer.WorkerJSONSerializer;
import com.edutilos.main.serializer.WorkerXMLSerializer;
import com.edutilos.main.tableView.Worker;

import java.util.Arrays;
import java.util.List;

/**
 * Created by edutilos on 15.06.18.
 */
public class Tester {
    public static void main(String[] args) {
        System.out.println("<<testWorkerXMLSerializer>>");
        testWorkerXMLSerializer();
        System.out.println();
        System.out.println("<<testWorkerCSVSerializer>>");
        testWorkerCSVSerializer();
        System.out.println();
        System.out.println("<<testWorkerJSONSerializer>>");
        testWorkerJSONSerializer();
        System.out.println();
    }


    private static void testWorkerJSONSerializer() {
        List<Worker> workers = Arrays.asList(
                new Worker(1L, "foo", 10, 100.0, true),
                new Worker(2L, "bar", 20, 200.0, false),
                new Worker(3L, "bim", 30, 300.0, true)
        );
        WorkerJSONSerializer serializer = new WorkerJSONSerializer();
        String filename = "Workers.json";
        serializer.writeIntoJSON(workers, filename);

/*        String x = "<Name>foobar</Name>";
        String [] splitted = x.split("<\\/{0,1}\\w+>");
        System.out.println(splitted.length);
        for(String s: splitted)
            System.out.println(s);*/

        List<Worker> res = serializer.readFromJSON(filename);
        res.forEach((w)-> System.out.println(w.toString()));

    }

    private static void testWorkerCSVSerializer() {
        List<Worker> workers = Arrays.asList(
                new Worker(1L, "foo", 10, 100.0, true),
                new Worker(2L, "bar", 20, 200.0, false),
                new Worker(3L, "bim", 30, 300.0, true)
        );
        WorkerCSVSerializer serializer = new WorkerCSVSerializer();
        String filename = "Workers.csv";
        serializer.writeIntoCSV(workers, filename);

/*        String x = "<Name>foobar</Name>";
        String [] splitted = x.split("<\\/{0,1}\\w+>");
        System.out.println(splitted.length);
        for(String s: splitted)
            System.out.println(s);*/

        List<Worker> res = serializer.readFromCSV(filename);
        res.forEach((w)-> System.out.println(w.toString()));

    }


    private static void testWorkerXMLSerializer() {
        List<Worker> workers = Arrays.asList(
           new Worker(1L, "foo", 10, 100.0, true),
                new Worker(2L, "bar", 20, 200.0, false),
                new Worker(3L, "bim", 30, 300.0, true)
        );
        WorkerXMLSerializer serializer = new WorkerXMLSerializer();
        String filename = "Workers.xml";
        serializer.writeIntoXML(workers, filename);

/*        String x = "<Name>foobar</Name>";
        String [] splitted = x.split("<\\/{0,1}\\w+>");
        System.out.println(splitted.length);
        for(String s: splitted)
            System.out.println(s);*/

        List<Worker> res = serializer.readFromXML(filename);
        res.forEach((w)-> System.out.println(w.toString()));

    }
}
