package com.edutilos.fxml.model;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
public class Person {
    private SimpleObjectProperty<Long> idProp;
    private SimpleStringProperty nameProp;
    private SimpleObjectProperty<Integer> ageProp;
    private SimpleObjectProperty<Double> wageProp;
    private SimpleObjectProperty<Boolean> activeProp;

    public Person() {
        this(0L, "", 0, 0.0, false);
    }

    public Person(Long id, String name, Integer age, Double wage, Boolean active) {
        idProp = new SimpleObjectProperty<>(id);
        nameProp = new SimpleStringProperty(name);
        ageProp = new SimpleObjectProperty<>(age);
        wageProp = new SimpleObjectProperty<>(wage);
        activeProp = new SimpleObjectProperty<>(active);
    }

    public static Person generatyDummyWorker()  {
        return new Person(1L, "foo", 10, 100.0, true);
    }

    public Long getId() {
        return idProp.get();
    }
    public String getName() {
        return nameProp.get();
    }
    public Integer getAge() {
        return ageProp.get();
    }
    public Double getWage() {
        return wageProp.get();
    }
    public Boolean getActive() {
        return activeProp.get();
    }

    public void setId(Long id) {
        idProp.set(id);
    }
    public void setName(String name) {
        nameProp.set(name);
    }
    public void setAge(Integer age) {
        ageProp.set(age);
    }
    public void setWage(Double wage) {
        wageProp.set(wage);
    }
    public void setActive(Boolean active) {
        activeProp.set(active);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Person{");
        sb.append(idProp.get()).append(",")
                .append(nameProp.get()).append(",")
                .append(ageProp.get()).append(",")
                .append(wageProp.get()).append(",")
                .append(activeProp.get()).append("}");
        return sb.toString();
    }
}
