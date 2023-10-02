package model;

import java.util.List;

public class User {
    protected int id;
    protected String name;
    protected String email;
    protected String country;
    protected int cities_id;
    protected List<Person> persons;

    public User() {
    }
    public User(String name, String email, String country, int cities_id) {
        super();
        this.name = name;
        this.email = email;
        this.country = country;
        this.cities_id = cities_id;
    }
    public User(int id, String name, String email, String country, int cities_id) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.country = country;
        this.cities_id = cities_id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public int getCities_id() {
        return cities_id;
    }
    public void setCities_id(int cities_id) {
        this.cities_id = cities_id;
    }
}