package model;

import pojo.Location;
import pojo.PersonDetail;

public class User {
    private String id;
    private PersonDetail personDetail;
    private Location loc;



    public User(String id, PersonDetail personDetail, Location loc) {
        this.id = id;
        this.personDetail = personDetail;
        this.loc = loc;
    }



    public void setId(String id) {
        this.id = id;
    }

    public void setPersonDetail(PersonDetail personDetail) {
        this.personDetail = personDetail;
    }

    public void setLoc(Location loc) {
        this.loc = loc;
    }

    public String getId() {
        return id;
    }

    public PersonDetail getPersonDetail() {
        return personDetail;
    }

    public Location getLoc() {
        return loc;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", personDetail=" + personDetail +
                ", loc=" + loc +
                '}';
    }
}
