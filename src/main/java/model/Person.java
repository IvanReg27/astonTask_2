package model;

public class Person {
    protected int id;
    protected int user_id;
    protected int city_id;

    public Person() {
    }

    public Person(int id, int user_id, int city_id) {
        this.id = id;
        this.user_id = user_id;
        this.city_id = city_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }
}
