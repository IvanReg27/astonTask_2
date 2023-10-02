package model;

import java.util.List;

public class City {
    protected int id;
    protected String city;
    protected List<User> users;
    protected List<Person> persons;

    public City() {
    }

    public City(int id, String city) {
        this.id = id;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}