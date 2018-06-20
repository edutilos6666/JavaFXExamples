package com.edutilos.fxml.util;

import com.edutilos.fxml.model.Person;
import javafx.collections.ObservableList;

/**
 * Created by edutilos on 21.06.18.
 */
public class PersonUtils {
    public static boolean checkIfIdDuplicate(ObservableList<Person> data, long id) {
        for(Person p: data) {
            if(p.getId() == id) return true;
        }
        return false;
    }
}
