package com.edutilos.main.serializer;

import com.edutilos.main.tableView.Worker;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by edutilos on 15.06.18.
 */
public class WorkerJSONSerializer {
    private final String nl = "\n";
    private final String del = ",";
    public void writeIntoJSON(List<Worker> workers, String filename) {
        try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename,false)))) {
            StringBuilder sb = new StringBuilder();
            sb.append("[").append(nl);
            for(Worker w: workers) {
                sb.append("{");
                sb.append("\"id\":").append(w.getId()).append(del)
                        .append("\"name\":\"").append(w.getName()).append("\"").append(del)
                        .append("\"age\":").append(w.getAge()).append(del)
                        .append("\"wage\":").append(w.getWage()).append(del)
                        .append("\"active\":").append(w.isActive())
                        .append("}")
                        .append(",").append(nl);
            }
            sb.replace(sb.length()-2, sb.length(), "\n]");
            writer.write(sb.toString());
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Worker> readFromJSON(String filename) {
        List<Worker> res = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)))) {
            String line = null;
            while((line = reader.readLine()) != null && !line.startsWith("]")) {
                if(line.startsWith("[")) line = reader.readLine();
                line = line.substring(1, line.length()-2);
                String[] splitted = line.split(del);
                if(splitted.length != 5) throw new Exception("splitted.length != 5");
                long id = Long.parseLong(splitted[0].split(":")[1]);
                String name = splitted[1].split(":")[1];
                int age = Integer.parseInt(splitted[2].split(":")[1]);
                double wage = Double.parseDouble(splitted[3].split(":")[1]);
                boolean active = splitted[4].split(":")[1].equalsIgnoreCase("true");
                res.add(new Worker(id, name, age, wage, active));
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return res;
    }


    public String readFromJSONAsString(String filename) {
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
