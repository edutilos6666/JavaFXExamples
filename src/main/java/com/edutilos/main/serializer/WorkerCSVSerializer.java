package com.edutilos.main.serializer;

import com.edutilos.main.tableView.Worker;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by edutilos on 15.06.18.
 */
public class WorkerCSVSerializer {
    private final String nl = "\n";
    private final String del = ",";
    public void writeIntoCSV(List<Worker> workers, String filename) {
        try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename,false)))) {
            StringBuilder sb = new StringBuilder();

            for(Worker w: workers) {
                sb.append(w.getId()).append(del)
                        .append(w.getName()).append(del)
                        .append(w.getAge()).append(del)
                        .append(w.getWage()).append(del)
                        .append(w.isActive()).append(nl);
                writer.write(sb.toString());
                sb = new StringBuilder();
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Worker> readFromCSV(String filename) {
        List<Worker> res = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)))) {
            String line = null;
            while((line = reader.readLine()) != null) {
                String[] splitted = line.split(del);
                if(splitted.length != 5) throw new Exception("splitted.length != 5");
                long id = Long.parseLong(splitted[0]);
                String name = splitted[1];
                int age = Integer.parseInt(splitted[2]);
                double wage = Double.parseDouble(splitted[3]);
                boolean active = splitted[4].equalsIgnoreCase("true");
                res.add(new Worker(id, name, age, wage, active));
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return res;
    }


    public String readFromCSVAsString(String filename) {
        StringBuilder sb = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)))) {
            String line = null;
            while((line = reader.readLine())!= null) {
                sb.append(line).append(nl);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        return sb.toString();
    }
}
