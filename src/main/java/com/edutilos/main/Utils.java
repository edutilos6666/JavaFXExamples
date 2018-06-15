package com.edutilos.main;

import com.edutilos.main.tableView.Worker;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edutilos on 15.06.18.
 */
public class Utils {
    public static List<Worker> convertObserableListToClassicList(ObservableList<Worker> workers) {
        List<Worker> res = new ArrayList<>();
        for(Worker w: workers) {
            res.add(w);
        }
        return res;
    }
}
