package com.edutilos.main.serializer;

import com.edutilos.main.tableView.Worker;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by edutilos on 15.06.18.
 */
public class WorkerXMLSerializer {
    private final String xmlDecl = "<?xml version='version_number' encoding='UTF-8' standalone='standalone_status' ?>";
    private final String nl = "\n";
    public void writeIntoXML(List<Worker> workers, String filename) {
//        System.out.println(WorkerXMLSerializer.class.getProtectionDomain().getCodeSource().getLocation().getPath());
//        System.out.println(WorkerXMLSerializer.class.getClassLoader().getResource(".").getPath()+filename);
//        System.out.println(WorkerXMLSerializer.class.getResource(".").getPath());
        try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename,false)))) {
            StringBuilder sb = new StringBuilder(xmlDecl).append(nl);
            sb.append("<Workers>").append(nl);
            for(Worker w: workers) {
                sb.append("<Worker>").append(nl)
                        .append("<Id>").append(w.getId()).append("</Id>").append(nl)
                        .append("<Name>").append(w.getName()).append("</Name>").append(nl)
                        .append("<Age>").append(w.getAge()).append("</Age>").append(nl)
                        .append("<Wage>").append(w.getWage()).append("</Wage>").append(nl)
                        .append("<Active>").append(w.isActive()).append("</Active>").append(nl)
                        .append("</Worker>").append(nl);
            }

            sb.append("</Workers>");
            writer.write(sb.toString());
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Worker> readFromXML(String filename) {
        List<Worker> res = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)))) {
            String line = reader.readLine();
            line = reader.readLine();
            List<String> lines = new ArrayList<>();
            while(line != null && !line.startsWith("</Workers>")) {
                lines.clear();
                //<Worker>
                line = reader.readLine();
                if(line == null) continue;
                lines.add(line);
                //Id
                line = reader.readLine();
                if(line == null) continue;
                lines.add(line);
                //Name
                line = reader.readLine();
                if(line == null) continue;
                lines.add(line);
                //Age
                line = reader.readLine();
                if(line == null) continue;
                lines.add(line);
                //Wage
                line = reader.readLine();
                if(line == null) continue;
                lines.add(line);
                //Active
                line = reader.readLine();
                if(line == null) continue;
                lines.add(line);
                //</Worker>
                line = reader.readLine();
                if(line == null) continue;
                lines.add(line);
                res.add(constructWorker(lines)); 
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        return res;
    }

    public String readFromXMLAsString(String filename) {
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


    private Worker constructWorker(List<String> lines)  {
        Worker w = Worker.generatyDummyWorker();
        String pattern = "<\\/{0,1}\\w+>";
        for(String line: lines) {
            if(line == null) continue;
            if(line.startsWith("<Id>")) {
                w.setId(Long.parseLong(line.split(pattern)[1]));
            } else if(line.startsWith("<Name>")) {
                w.setName(line.split(pattern)[1]);
            } else if(line.startsWith("<Age>")) {
                w.setAge(Integer.parseInt(line.split(pattern)[1]));
            } else if(line.startsWith("<Wage>")) {
                w.setWage(Double.parseDouble(line.split(pattern)[1]));
            } else if(line.startsWith("<Active>")) {
                w.setActive(line.split(pattern)[1].equalsIgnoreCase("true"));
            }
        }
        return w;
    }
}
